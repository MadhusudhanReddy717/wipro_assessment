package assessment;

import java.util.*;

class CD implements Comparable<CD> {
    private String title;
    private String singer;

    public CD(String title, String singer) {
        this.title = title;
        this.singer = singer;
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    @Override
    public int compareTo(CD other) {
        return this.singer.compareToIgnoreCase(other.singer);
    }

    @Override
    public String toString() {
        return "CD Title: " + title + ", Singer: " + singer;
    }
}

public class Q40 {
    public static void main(String[] args) {
        List<CD> cds = new ArrayList<>();
        cds.add(new CD("Love Yourself", "Justin Bieber"));
        cds.add(new CD("Rolling in the Deep", "Adele"));
        cds.add(new CD("Shape of You", "Ed Sheeran"));
        cds.add(new CD("Blank Space", "Taylor Swift"));

        Collections.sort(cds);

        System.out.println("CDs sorted by Singer (Ascending):");
        for (CD cd : cds) {
            System.out.println(cd);
        }
    }
}
