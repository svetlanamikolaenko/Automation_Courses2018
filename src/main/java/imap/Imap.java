package imap;

import javax.mail.*;
import javax.mail.search.SearchTerm;
import java.util.ArrayList;
import java.util.Properties;


public class Imap {

	protected Store openConnection(String email, String password, String host) {
		Store store = null;
		try {
			Properties properties = new Properties();
			Session session = Session.getInstance(properties);
			store = session.getStore("imaps");
			store.connect(host, email, password);
		} catch (Exception e) {
			System.err.println(e);
		}
		return store;
	}

	protected Folder openFolder(Store store, String folderName) {
		Folder folder = null;
		try {
			folder = store.getFolder(folderName);
			folder.open(Folder.READ_WRITE);
		} catch (Exception e) {
			System.err.println(e);
		}
		return folder;
	}

	protected void close(Folder folder) {
		try {
			folder.close(true);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	protected void close(Store store) {
		try {
			store.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	protected ArrayList<Message> searchMessagesIn(SearchTerm term, Folder folder) {
		ArrayList<Message> messages = new ArrayList<>();
		try {
			for (Message message : folder.search(term)) {
				messages.add(message);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return messages;
	}

	protected ArrayList<Message> searchMessagesIn(Folder folder) {
		ArrayList<Message> messages = new ArrayList<>();
		try {
			for (Message message : folder.getMessages()) {
				messages.add(message);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return messages;
	}

	public void delete(Message message) {
		try {
			message.setFlag(Flags.Flag.DELETED, true);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
