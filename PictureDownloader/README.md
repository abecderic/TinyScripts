# PictureDownloader
This program helps to download images from the internet when the imagenames differ in a number.

PictureDownloader takes four commandline arguments. The url up to the number, the url after the number, the number to start from and the number to end at.
If some images in the order are missing, the program will tell you that much, but then simply continue with the next one.

The images are saved as .jpg with the filename <number>.jpg in the folder this program is running in.

## Example
Say, you want to download the images `img42.jpg` to `img69.jpg` from `example.com` where the first image is at `example.com/img42.jpg`. Then you start the program with 
```java
java PictureDownloader "example.com/img" ".jpg" 42 69
```
You can omit the quotation marks if the string doesn't contain a space.