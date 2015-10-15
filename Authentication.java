import javax.swing.JOptionPane;

public class Authentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] corUser = { "Hollan", "Dean", "Holmes" };
		String[] corPass = { "123", "1234", "12345" };
		String[] choices = { "Admin", "Student", "Staff" };
		int u = 0;
		int LIMIT = 3;
		boolean Loop = true;
		do {
			String userInput1 = JOptionPane.showInputDialog("Enter username");
			if (userInput1.equals(corUser[u])) {
				String userInput2 = JOptionPane.showInputDialog("Enter password");
				if (userInput2.equals(corPass[u])) {
					Loop = false;
					JOptionPane.showMessageDialog(null, "Welcome " + corUser[u] + "!");
					String userInput3 = (String) JOptionPane.showInputDialog(null, "Choose account type below",
							"Account Type", JOptionPane.QUESTION_MESSAGE, null, choices, choices[2]);
					while ((userInput3 != null) && userInput3.equals(choices[u])) {
						switch (userInput3) {
						case "Admin":
							JOptionPane.showMessageDialog(null, "Welcome Admin! You can update and read file.");
							break;
						case "Student":
							JOptionPane.showMessageDialog(null, "Welcome Student! You can only read file.");
							break;
						case "Staff":
							JOptionPane.showMessageDialog(null,
									"Welcome Staff! You can update, read, add, delete file.");
							break;
						}
						System.exit(0);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Password!", "Error", JOptionPane.ERROR_MESSAGE);
					u++;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Invalid Username!", "Error", JOptionPane.ERROR_MESSAGE);
				u++;
			}
			if (u != choices.length && Loop == false) {
				JOptionPane.showMessageDialog(null, "Wrong Account Type!", "Error", JOptionPane.ERROR_MESSAGE);
				u++;
			}
			if (u >= LIMIT) {
				JOptionPane.showMessageDialog(null, "Account Locked!\nContact Administrator!", "Warning",
						JOptionPane.WARNING_MESSAGE);
			}
		} while (u < corUser.length);
	}
}