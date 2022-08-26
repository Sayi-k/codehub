package org.core.java8.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SubListTraverse {

	public static void main(String[] args) {
		List<Album> albums = new ArrayList<>();
		albums.add(new Album("Cora", Arrays.asList(new Track(4), new Track(3))));
		albums.add(new Album("Zack", Arrays.asList(new Track(2), new Track(3))));
		albums.add(new Album("Trap", Arrays.asList(new Track(5), new Track(3), new Track(4))));
		
		/* Favorite albums whose track rating is 5 */
		List<Album> favs = 
		albums.stream()
		.filter(album -> album.getTracks().stream().anyMatch(track -> track.getRating() == 5))
		.collect(Collectors.toList());
		
		System.out.println(favs);
		
		System.out.println("====================");
		System.out.println("Sort based on Album names");
		
		albums.stream().sorted(Comparator.comparing(Album::getName)).forEach(System.out::println);;
		System.out.println(albums);
	}

}

class Album{
	
	String name;
	List<Track> tracks;
	
	public Album(String name, List<Track> tracks) {
		super();
		this.name = name;
		this.tracks = tracks;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Track> getTracks() {
		return tracks;
	}
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return "Album [name=" + name + ", tracks=" + tracks + "]";
	}
}

class Track{
	int rating;

	public Track(int rating) {
		this.rating = rating;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Track [rating=" + rating + "]";
	}
}


/*
 * List<Album> favs = new ArrayList<>();
for (Album a : albums) {
    boolean hasFavorite = false;
    for (Track t : a.tracks) {
        if (t.rating >= 4) {
            hasFavorite = true;
            break;
        }
    }
    if (hasFavorite)
        favs.add(a);
}
Collections.sort(favs, new Comparator<Album>() {
                           public int compare(Album a1, Album a2) {
                               return a1.name.compareTo(a2.name);
}});
 * */
