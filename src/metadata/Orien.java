package metadata;


import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifReader;
import com.drew.metadata.iptc.IptcReader;
import com.drew.metadata.jpeg.JpegDirectory;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Orien {

	 /**
     * Executes the sample usage program.
     *
     * @param args command line parameters
     */
    public static void main(String[] args)
    {
    	try{
            File file = new File("/Users/jose/Desktop/Exif/Landscape_3.jpg");
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            print(metadata);
//            Directory directory = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
//            JpegDirectory jpegDirectory = metadata.getFirstDirectoryOfType(JpegDirectory.class);
//            int orientation = directory.getInt(ExifIFD0Directory.TAG_ORIENTATION);
//            System.out.println("Orientation : "+orientation);
    	}catch(Exception e){
    		System.out.println("Exception : "+e.getMessage());
    	}

        
    }

    private static void print(Metadata metadata)
    {
        System.out.println("-------------------------------------");

        // Iterate over the data and print to System.out

        //
        // A Metadata object contains multiple Directory objects
        //
        try{
        for (Directory directory : metadata.getDirectories()) {

            //
            // Each Directory stores values in Tag objects
            //
            for (Tag tag : directory.getTags()) {
                System.out.println(tag);
            }

            //
            // Each Directory may also contain error messages
            //
            if (directory.hasErrors()) {
                for (String error : directory.getErrors()) {
                    System.err.println("ERROR: " + error);
                }
            }
        }
        }catch(Exception e){
        	System.out.println("Exception : "+e.getMessage());
        }
    }

}
