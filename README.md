# Auto Clicker

Auto Clicker is a program written in Java that automatically clicks the mouse until the user turns it off. This program is ideal for repetitive tasks that require frequent clicking, such as gaming or data entry.

## Features

- Automatically clicks the mouse at a user-defined interval
- Easy to use interface
- User-defined stop criteria

## Requirements

- Java SE Development Kit (JDK) 8 or later
- A Java IDE, such as Eclipse or IntelliJ IDEA
- `system-hook` Library

## Installation

1. Clone the repository to your local machine using the following command:

```sh 
$ git clone https://github.com/RyanMcGrath1/AutoClicker.git
```

2. Import the project into your preferred Java IDE.

3. Run the program from your IDE.

## Usage

Upon running the program, the user will be shown the connected mouse. The user will click the middle mouse wheel to begin automatically clicking the mouse at the specified interval. The user can terminate the program by clicking in the middle mouse wheel again.
The interval is by default set to 1000 milliseconds. 
## Contributing

Contributions are welcome! If you have an idea for a new feature or find a bug, please open an issue or submit a pull request.

## Dependencies

This project uses the [System-Hook](https://github.com/kristian/system-hook) library. 

The `system-hook` dependency is created and maintained by [https://github.com/kristian](https://github.com/kristian). The ``system-hook`` dependency can be found as a `.jar` file [here](https://github.com/kristian/system-hook/releases), alternatively the `Maven` dependency can be found [here](https://github.com/kristian/system-hook#maven-dependency).
