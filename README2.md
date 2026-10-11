# Overview of Assignment

This assignment required the student to modify a prebuilt Spring Boot Application.
The application is a store that sells model rockets and parts.

## Technology used:

### Front End:
HTML, CSS

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

## Commit history (Modifications made):

Below is a copy of the GitLab commit history (GitLab was the platform used at the time), and it explains each modification
made to the Application.

C. In ...target/templates/mainscreen.html, changed the contents of title tag of line 14, and h1 tag of line 19 to
     "Moe's Model Rockets".  Also added 5 parts and products using the browser.   

D. Added another controller named AboutPage (...demo\controllers\AboutPage.java) to 
     create the about page.  Added a link to about.html in mainscreen.html on line
     21.  In about.html, typed out the about message on lines 10 and 11
     , and created a link that directs users back to mainscreen.html on line 12.

C. Back to part C.  I believe I misunderstood the instructions for part c.  I added
   5 parts and products using the "add inhouse part" and "add product" buttons, but 
   the instructions wanted the student to rename "Parts" and "Products" (the contents
   of the h2 tags on lines 23 and 55 of mainscreen.html)?  Just renamed those
   Rocket Parts, and Rockets respectively.

E. Created 5 parts and 5 products in lines 43 through 89 of BootStrapData.java.

F. Created success.html and failure.html pages and each have a link to mainscreen.  Added 
    buy now link to line 87 of mainscreen.html.  Added logic to decrement 
    the relevant item in inventory if it exists in inventory or if the item is out
    of stock then send the user to the failure page.  This function was
    put in AddProductcontroller.java on lines 183-198.

G. Added minInv and maxInv variable to lines 35-39 of Part.java and added corresponding
   getter and setter methods to lines 102-114 of the same file.  Added fields Min Inventory,
    and Max Inventory to home page by adding relevant tags to lines, 40-41, and 50-51
    of mainscreen.html.  In BootStrapData.java made changes on lines 64-65, 71-72, 78-79,
    85-86, 92-93, to set minInv, and maxInv for each part.  Added additional text fields
    to inHouse and outSource part pages for min and max inventory by adding relevant tags to lines 24-28, and lines 25-29
    of InhousePartForm.html and OutsorcedPartform.html respectively.  Created pages InventoryValidator.java
    and ValidInventory.java to enforce that the inventory is between the min and max value
    for a given part.  Connected ValidInventory validator to the Part class by adding
    the annotation @ValidInventory to line 23 of Part.java.  Added tags to lines, 32-37 and 33-38 of
    InhousePartForm.html and OursourcedPartForm.html respectively to output error message if the
    inventory of a certain part is out of range.

H. Added an if statement to line 37 of EnufPartsValidator.java.  This statement
    will return false if the addition of a threshold number of products will make the inventory
    of the associated parts drop below the minimum inventory value.  Displaying an
    error message if the inventory of the parts drop below a minimum or is greater than
    a maximum was done in part G.

I. Added tests to lines 31-47 of PartTest.java to check if minInv and maxInv are positive.

J. The deletePartsValidator had no usages so that file was deleted.

L. Assignment was kicked back.  The customizations to the html did not take effect because I modified 
    the html files that were in the target folder instead of the html files that were in the src folder.
