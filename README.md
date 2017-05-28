# MyGalleryImage

A native gallery image for android, this project is open source for everyone.

If you wanna use externaly as a library, just follow this easy steps to invoke a gallery:

/*
Declare and instance the GalleryManager and pass the actual context from your activity
*/
MyGalleryManager gm = new MyGalleryManager(this);
        
/*
Push data image to the manager (Name of the image, url or base 64)
*/
for(int i =0; i<10;i++) {
      gm.pushImage("IMAGE 1", "https://www.qdtricks.net/wp-content/uploads/2016/05/latest-1080-wallpaper.jpg");
}
 
/*
Load the gallery 
*/
gm.LoadGallery();
