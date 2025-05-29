package dev.codecounty.java.java8.specials.streams;


/*Assuming you have a set of Photo objects with attributes url, photographer,
 and alt, the goal is to find the photo with the smallest alt text.
 If multiple photos have the same alt length, you should then select the
 photo with the smallest name of the photographer.*/

import java.util.Comparator;
import java.util.Set;

public class PhotographMetaDataFilterQuestion {

    public static void main(String[] args) {
        Set<Photo> photos = Set.of(
                new Photo("https://www.pexels.com/photo/rocket-flying-2163/", "Pixabay", "Rocket Flying"),
                new Photo("https://www.pexels.com/photo/gray-animal-skull-208139/", "Polina Tankilevitch", "Glass Lab Equipment"),
                new Photo("https://www.pexels.com/photo/heap-of-pills-on-yellow-background-4210606/", "Karolina Grabowska", "Rocket FlyingView of Modern Building")
        );


        //Without using streams
        Photo bestPhoto = new Photo("", "", "");
        for (Photo curPhoto : photos) {
            int curPhotoTitleLength = curPhoto.alt().length();
            int bestPhotoTitleLength = bestPhoto.alt().length();
            if (curPhotoTitleLength == bestPhotoTitleLength) {
                int curPhotographerLength = curPhoto.photographer().length();
                int bestPhotographerLength = bestPhoto.photographer().length();
                bestPhoto = curPhotographerLength < bestPhotographerLength ? curPhoto : bestPhoto;
            } else if (curPhotoTitleLength < bestPhotoTitleLength) {
                bestPhoto = curPhoto;
            }
        }
        System.out.println("Photo with minimum alt text: " + bestPhoto);


//        using streams

//        Comparator<Photo> altLengthComparator = (photo1, photo2) -> photo1.alt().length() - photo2.alt().length();
        Comparator<Photo> altLengthComparator = Comparator.comparingInt(photo -> photo.alt().length());
//        Comparator<Photo> photographerLengthComparator = (photo1, photo2) -> photo1.photographer().length() - photo2.photographer().length();
        Comparator<Photo> photographerLengthComparator = Comparator.comparingInt(photo -> photo.photographer().length());


//        Photo photoWithMinAltText = photos.stream()
//                .min(altLengthComparator.thenComparing(photographerLengthComparator).reversed())
//                .get();

        Photo photoWithMinAltText = photos.stream()
                .max(altLengthComparator.thenComparing(photographerLengthComparator))
                .get();

        System.out.println("Photo with minumum alt text: " + photoWithMinAltText);


        //Alternate Way
        photoWithMinAltText = photos
                .stream()
                .min(Comparator.comparing(Photo::getAltLength).thenComparing(Photo::getPhotographerLength))
                .get();
        System.out.println("Photo with minumum alt text: " + photoWithMinAltText);


    }
}

record Photo(String uri, String photographer, String alt) {

    public int getAltLength() {
        return alt.length();
    }

    public int getPhotographerLength() {
        return photographer.length();
    }
}
