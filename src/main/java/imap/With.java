package imap;

import javax.mail.*;
import javax.mail.search.*;
import java.util.Date;
import java.util.Enumeration;

public class With {

	public static SearchTerm headerName(final String headerName) {

		SearchTerm searchCondition = new SearchTerm() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean match(Message message) {
				try {
					String[] value = message.getHeader(headerName);
					if (value != null) {
						return true;
					}

				} catch (MessagingException e) {
					e.printStackTrace();
				}
				return false;
			}
		};

		return searchCondition;
	}

	public static SearchTerm headerValue(final String headerValue) {

		SearchTerm searchCondition = new SearchTerm() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean match(Message message) {
				if (message == null) {
					System.err
							.println("=======================================================");
					System.err.println("MessagesStore is null");
				}
				try {
					Enumeration<?> headers = message.getAllHeaders();
					while (headers.hasMoreElements()) {
						Header h = (Header) headers.nextElement();
						if (h.getValue().equals(headerValue) || h.getValue().contains(headerValue))
							return true;
					}

				} catch (MessagingException e) {
					e.printStackTrace();
					System.out.println("Cannot load header " + headerValue);
				}
				return false;
			}
		};

		return searchCondition;
	}

	public static SearchTerm unseen() {
		Flags seen = new Flags(Flags.Flag.SEEN);
		return new FlagTerm(seen, false);
	}

	public static SearchTerm from(final String fromEmail) {
		SearchTerm searchCondition = new SearchTerm() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean match(Message message) {
				try {
					Address[] fromAddress = message.getFrom();
					if (fromAddress != null && fromAddress.length > 0) {
						if (fromAddress[0].toString().contains(fromEmail)) {
							return true;
						}
					}
				} catch (MessagingException ex) {
					ex.printStackTrace();
				}
				return false;
			}
		};

		return searchCondition;
	}

	public static SearchTerm subject(final String subject) {
		SearchTerm searchCondition = new SearchTerm() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean match(Message message) {
				try {
					if (message.getSubject().contains(subject)) {
						return true;
					}
				} catch (MessagingException ex) {
					ex.printStackTrace();
				}
				return false;
			}
		};

		return searchCondition;
	}

	public static SearchTerm receivedDate(final Date date) {
		return new ReceivedDateTerm(ComparisonTerm.EQ, date);
	}

	public static SearchTerm sentDate(final Date date) {
		return new SentDateTerm(ComparisonTerm.EQ, date);
	}

}
