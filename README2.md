# Overview of Assignment

This assignment required the student to modify a prebuilt Spring Boot Application.
The application is a hotel website where users can book rooms and view information about services and amenities.

## Technology used:

### Front End:
Angular, TypeScript, HTML, CSS

### Back End:
Spring Boot 2.6.6, Java 21.0.11

### IDE:
IntelliJ IDEA 2026.1

### OS:
Windows 11 

## How to Run the App (if IntelliJ is installed)
1.  Copy the URL of this repository by clicking Code on the repository's homepage and, under Clone, select HTTPS, then click Copy URL to clipboard.
2.  Open IntelliJ, and in the upper right, there is a button called Clone Repository; click it.
3.  You will be prompted for the version control source, URL, and Directory.
4.  For version control, select Git, then paste the copied URL into the field labeled URL.
6.  Also, you will see a field labeled Directory.  Choose a name for the Project's folder.
7.  Click Clone.  
8.  After the project loads, click the green triangular-shaped button.  This is located at the top of the window near the center. This will start the application.
9.  To view the application, open a browser and type http://localhost:8080 in the address bar, then press Enter.  The application will run here.

## Modifications made:

1.  Two welcome messages, which are the same message (one in French and the other in English), are displayed on the homepage.  The messages are displayed
    using multithreaded programming.  A new class called Threads was created along with a fixed thread pool.  For each message, the English or French version of the message (in the form of a string) was retrieved
    from a file type called a resource bundle and was returned to a data type called CompletableFuture<String>.  This was done for both messages concurrently, resulting in faster execution than running both processes sequentially.

2. Added the file MessageMapping.java to create a REST Controller, which is used to send the English and French versions of the message to the appropriate endpoint.

3. Made modifications to the TypeScript file app.component.ts to retrieve the French and English messages from the relevant endpoints.

4. Modified the file app.component.html (added h1 tags) to display both messages on the homepage.

5. Created the file DateTimeMapping.java to create a REST Controller that directs the Eastern, Standard, and Pacific times to the appropriate endpoints.

6. Made modifications to the TypeScript file app.component.ts to retrieve the Eastern, Standard, and Pacific times from the relevant endpoints.

7. Modified the file app.component.html (added h1 tags) to display the Eastern, Standard, and Pacific times.

8. Modified the file app.component.html to display room price in dollars, CAD, and Euros using the currency code and pipe character.

9. Created a Docker image of the application. 

![](images/image4.png)
