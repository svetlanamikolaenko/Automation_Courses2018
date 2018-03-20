package imap;

import org.apache.commons.io.IOUtils;

import javax.mail.*;
import javax.mail.search.SearchTerm;
import java.util.*;


public class ImapClient extends Imap {

    private String email;
    private String password;
    private String host;
    private String spamFolderName;

    private int timeout = 10;
    private int retry = 30;
    private int count = 0;

    private Store store;
    private Folder folder;

    public ImapClient(String email, String password) {
        this.email = email;
        this.password = password;
        getHostAndSpamFolderName();
    }

    public boolean isConnected() {
        return store != null && store.isConnected();
    }

    private boolean isFolderOpened() {
        return folder != null && folder.isOpen();
    }

    public Store getStore(){
        return store;
    }

    /**
     * Opening connection to store
     */
    public void connect() throws InterruptedException {
        count = 0;
        while (!isConnected() && count++ < retry) {
            System.out.println("Info: " + "Connecting to: " + email + ":" + password + " retry: "
                    + retry + ", timeout: " + timeout + " sec");
            store = openConnection(email, password, host);
            if (!isConnected() && count < retry)
                Thread.sleep(5000);
        }
    }

    /**
     * Closing connection to store
     */
    public void closeStore() {
        if (isConnected())
            close(store);
    }

    /**
     * Finding all messages in inbox and spam folder</br> by specific SearchTerm
     *
     * @return List<<code>MessagesStore</code>>
     */
    public List<Message> findMessages(SearchTerm term) throws InterruptedException {
        System.out.println("Info: " + "Searching for messages");
        ArrayList<Message> messages = new ArrayList<>();
        count = 0;
        if (isConnected()) {
            while (messages.size() == 0 && count < retry) {
                folder = openFolder(store, "Inbox");
                if (isFolderOpened()) {
                    searchMessagesIn(term, folder).forEach(messages::add);
                } else {
                    System.err.println("Error: " + "Failed to find messages, inbox folder is closed");
                }

                folder = openFolder(store, spamFolderName);
                if (isFolderOpened()) {
                    searchMessagesIn(term, folder).forEach(messages::add);
                } else {
                    System.err.println("Error: " + "Failed to find messages, spam folder is closed");
                }
                if (messages.size() == 0 && count++ < retry)
                    Thread.sleep(timeout * 1000);
            }
        } else {
            System.err.println("Error: " + "Failed to find messages, store is not connected");
        }
        return messages;
    }

        public List<Message> findMessages(SearchTerm term, int retry, int timeout) throws InterruptedException {
            System.out.println("Info: " + "Searching for messages");
            ArrayList<Message> messages = new ArrayList<>();
            count = 0;
            if (isConnected()) {
                do {
                    folder = openFolder(store, "Inbox");
                    if (isFolderOpened()) {
                        searchMessagesIn(term, folder).forEach(messages::add);
                    } else {
                        System.err.println("Error: " + "Failed to find messages, inbox folder is closed");
                    }

                    folder = openFolder(store, spamFolderName);
                    if (isFolderOpened()) {
                        searchMessagesIn(term, folder).forEach(messages::add);
                    } else {
                        System.err.println("Error: " + "Failed to find messages, spam folder is closed");
                    }
                    if (messages.size() == 0 && count++ < retry)
                        Thread.sleep(timeout * 1000);
                } while (messages.size() == 0 && count < retry);
            } else {
                System.err.println("Error: " + "Failed to find messages, store is not connected");
            }
            return messages;
        }

    /**
     * Finding all messages in inbox and spam folder
     *
     * @return List<<code>MessagesStore</code>>
     */
    public ArrayList<Message> findMessages() {
        System.out.println("Info: " + "Searching for messages");
        ArrayList<Message> messages = new ArrayList<>();
        if (isConnected()) {
            /* Searching messages in inbox folder */
            folder = openFolder(store, "Inbox");
            if (isFolderOpened()) {
                searchMessagesIn(folder).forEach(messages::add);
            } else {
                System.err.println("Error: " + "Failed to find messages, inbox folder is closed");
            }
            /* Searching messages in spam folder */
            folder = openFolder(store, spamFolderName);
            if (isFolderOpened()) {
                searchMessagesIn(folder).forEach(messages::add);
            } else {
                System.err.println("Error: " + "Failed to find messages, inbox folder is closed");
            }
        } else {
            System.err.println("Error: " + "Failed to find messages, store is not connected");
        }
        return messages;
    }


    /**
     * Deleting all messages in inbox and spam folders
     */
    public void deleteAllMessages() {
        if (isConnected()) {
            /* Deleting all messages from inbox folder */
            folder = openFolder(store, "Inbox");
            if (isFolderOpened()) {
                searchMessagesIn(folder).forEach(this::delete);
                close(folder);
                System.out.println("Inbox folder is clear");
            } else
                System.err.println("Error: " + "Failed to delete messages, inbox folder is closed");
            /* Deleting all messages from spam folder */
            folder = openFolder(store, spamFolderName);
            if (isFolderOpened()) {
                searchMessagesIn(folder).forEach(this::delete);
                close(folder);
                System.out.println("Spam folder is clear");
            } else
                System.err.println("Error: " + "Failed to delete messages, inbox folder is closed");
        } else
            System.err.println("Error: " + "Failed to delete messages, store is not connected");
    }

    public String getContent(Message message) {
        if (isConnected()) {
            try {
                Object body = message.getContent();
                if (body instanceof Multipart) {
                    Multipart multipart = (Multipart) message.getContent();
                    BodyPart bodyPart = multipart.getBodyPart(1);
                    return IOUtils.toString(bodyPart.getInputStream(), "UTF-8");
                } else {
                    return body.toString();
                }
            } catch (Exception e) {
                System.out.println("Warning: " + e.getMessage());
            }
        }
        System.err.println("Error: "
                + "Failed to get message content, store is not connected");
        return "none";
    }

    public String getHeader(Message message, String header) {
        if (isConnected()) {
            try {
                return message.getHeader(header)[0];
            } catch (NullPointerException e) {
                System.out.println("Warning: " +"Header [" + header + "] not found");
            } catch (MessagingException me) {
                System.out.println("Warning: " + me.getMessage());
            }
        } else {
            System.err.println("Error: " + "Failed to get header [" + header
                    + "] is disconnected");
        }
        return "none";
    }

    @SuppressWarnings("unchecked")
    public List<String> getAllHeaders(Message message) {
        List<String> headersList = new ArrayList<>();
        Enumeration<Header> headers = null;
        try {
            headers = message.getAllHeaders();
        } catch (MessagingException e) {
            e.printStackTrace();
            return headersList;
        }
        while (headers.hasMoreElements()) {
            Header h = headers.nextElement();
            headersList.add(h.getName() + ": " + h.getValue());
        }
        return headersList;
    }

    public HashMap<String, String> getAllHeadersMap(Message message) {
    HashMap<String, String> headersMap = new HashMap<>();
    Enumeration<Header> headers = null;
    try {
    headers = message.getAllHeaders();
    } catch (MessagingException e) {
    e.printStackTrace();
    return headersMap;
    }
    while (headers.hasMoreElements()) {
    Header h = headers.nextElement();
    headersMap.put(h.getName(), h.getValue());
    }
    return headersMap;
    }

    public String getSubject(Message message) {
        try {
            return message.getSubject();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return "none";
    }

    public String getFolderName(Message message) {
        try {
            return message.getFolder().getName().contains("Inbox") ? "Inbox"
                    : "Spam";
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return "none";
    }

    public Date getSentDate(Message message) {
        try {
            return message.getSentDate();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return new Date();
    }

    public Date getReceivedDate(Message message) {
        try {
            return message.getReceivedDate();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return new Date();
    }

    /* Винести в різні класи і удалить на хуй!!!! */
    public List<Message> sortMessagesBySentDate(List<Message> messages) {
        Collections.sort(messages, new Comparator<Message>() {
            public int compare(Message m1, Message m2) {
                Date date1 = getSentDate(m1);
                Date date2 = getSentDate(m2);
                return date1.compareTo(date2);
            }
        });
        return messages;
    }

    public List<Message> sortMessagesByReceivedDate(List<Message> messages) {
        Collections.sort(messages, new Comparator<Message>() {
            public int compare(Message m1, Message m2) {
                Date date1 = getReceivedDate(m1);
                Date date2 = getReceivedDate(m2);
                return date1.compareTo(date2);
            }
        });
        return messages;
    }

    private void getHostAndSpamFolderName() {
        if (email.contains("hotmail") || (email.contains("outlook"))) {
            host = "imap-mail.outlook.com";
            spamFolderName = "Junk";
        } else if (email.contains("gmail") || email.contains("onthe.io")) {
            host = "imap.gmail.com";
            spamFolderName = "[Gmail]/Spam";
        } else if (email.contains("yahoo")) {
            host = "imap.mail.yahoo.com";
            spamFolderName = "Bulk Mail";
        } else if (email.contains("mail.ru")) {
            host = "imap.mail.ru";
            spamFolderName = "Спам";
        } else if (email.contains("yandex")) {
            host = "imap.yandex.com";
            spamFolderName = "Spam";
        } else
            throw new NullPointerException(
                    "Unable to determine data for this email [" + email + "]");
    }

}
