Automated-Tests-With-Selenium

Keyword Search Page	
A simple, static HTML tool that enables users to convert between various area measurement units. Users can input a numeric value, choose source and target units, and instantly see the result

Features
Converts between:
•	Square meters
•	Square kilometers
•	Square feet
•	Square inches
•	Acres
•	Hectares
-  Easy-to-use dropdowns for unit selection
-  Friendly Bulgarian-language interface
-  Error message for invalid input
-  Responsive and centered UI
-  Lightweight (no backend or libraries required)

Functionality
•	Users enter a numeric value and select a source and target unit
•	Clicking the "Преобразувай" button performs the conversion using predefined rates
•	Result is displayed below the button
•	If input is invalid (e.g., "abc"), a validation message appears

UI Tests with Selenium
Automated tests verify the core functionality of the area converter. The test suite includes:
•	Valid conversion: e.g., 10,000 m² ➝ 1 hectare
•	 Reverse conversion: 1 hectare ➝ 10,000 m²
•	 Invalid input: displays a validation message
•	 Local loading of HTML page via file:// protocol
•	 Uses JUnit and Selenium WebDriver (ChromeDriver)

Run the tests (via your IDE or terminal):
•	Ensure JUnit and Selenium are added to your project.
•	Run AreaConverterTest.java.
