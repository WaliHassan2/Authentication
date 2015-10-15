import javax.swing.JOptionPane;

public class Authentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] corUser = { "Hollan", "Dean", "Holmes" };
		// correct usernames
		String[] corPass = { "123", "1234", "12345" };
		// correct passwords
		String[] choices = { "Admin", "Student", "Staff" };
		// account choices
		int u = 0;
		// index for counter termination
		int LIMIT = 3;
		// limit for counter termination
		boolean Loop = true;
		do {
			String userInput1 = JOptionPane.showInputDialog("Enter username");
			if (userInput1.equals(corUser[u])) {
				String userInput2 = JOptionPane.showInputDialog("Enter password");
				if (userInput2.equals(corPass[u])) {
					Loop = false;
					// determines if the correct password has already been entered for later error messages
					JOptionPane.showMessageDialog(null, "Welcome " + corUser[u] + "!");
					do{String userInput3 = (String) JOptionPane.showInputDialog(null, "Choose account type below",
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
					}while(Loop==false);
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
