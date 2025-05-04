package com.example.ebookyoop.service;

import com.example.ebookyoop.model.Book;
import com.example.ebookyoop.model.Ebook;
import com.example.ebookyoop.model.PrintedBook;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    private static final String FILE_NAME = "books.txt";

    public BookService(){
//        List<Book> books = new ArrayList<>();
//
//        books.add(new Ebook("Design and Build Websites", "Jon Duckett", "Web Development", "123435345364",
//                "https://prodimage.images-bn.com/pimages/9781118008188_p1_v2_s600x595.jpg",
//                "2.5MB", "https://example.com/ebook1"));
//
//        books.add(new Ebook("Clean Code", "Robert C. Martin", "Software Engineering", "9780132350884",
//                "https://m.media-amazon.com/images/I/41SH-SvWPxL.jpg",
//                "3MB", "https://example.com/ebook2"));
//
//        books.add(new Ebook("Introduction to Algorithms", "Thomas H. Cormen", "Algorithms", "9780262033848",
//                "https://m.media-amazon.com/images/I/41WEnHbNrrL.jpg",
//                "5MB", "https://example.com/ebook3"));
//
//        books.add(new Ebook("Effective Java", "Joshua Bloch", "Programming", "9780134685991",
//                "https://m.media-amazon.com/images/I/41kTRkCNAKL.jpg",
//                "4.5MB", "https://example.com/ebook4"));
//
//        books.add(new Ebook("You Don't Know JS", "Kyle Simpson", "JavaScript", "9781491904244",
//                "https://m.media-amazon.com/images/I/81kqrwS1nNL.jpg",
//                "2MB", "https://example.com/ebook5"));
//
//        books.add(new Ebook("The Pragmatic Programmer", "Andrew Hunt", "Software Engineering", "9780201616224",
//                "https://m.media-amazon.com/images/I/51A5cHQhSqL.jpg",
//                "3.2MB", "https://example.com/ebook6"));
//
//        books.add(new Ebook("Head First Design Patterns", "Eric Freeman", "Software Design", "9780596007126",
//                "https://m.media-amazon.com/images/I/81gtKoapHFL.jpg",
//                "6MB", "https://example.com/ebook7"));
//
//        books.add(new Ebook("Cracking the Coding Interview", "Gayle Laakmann McDowell", "Programming", "9780984782857",
//                "https://m.media-amazon.com/images/I/51R5XG4XACL.jpg",
//                "5.5MB", "https://example.com/ebook8"));
//
//        books.add(new Ebook("Refactoring", "Martin Fowler", "Software Development", "9780201485677",
//                "https://m.media-amazon.com/images/I/51k+a1RXl8L.jpg",
//                "4MB", "https://example.com/ebook9"));
//
//        books.add(new Ebook("JavaScript: The Good Parts", "Douglas Crockford", "Programming", "9780596517748",
//                "https://m.media-amazon.com/images/I/51gdVAEfPUL.jpg",
//                "1.5MB", "https://example.com/ebook10"));
//
//        // 10 PrintedBooks
//        books.add(new PrintedBook("The Mythical Man-Month", "Frederick P. Brooks Jr.", "Software Engineering", "9780201835953",
//                "https://m.media-amazon.com/images/I/51dRz0xJkDL.jpg", 5));
//
//        books.add(new PrintedBook("The Clean Coder", "Robert C. Martin", "Programming", "9780137081073",
//                "https://m.media-amazon.com/images/I/41kQDB8WQ8L.jpg", 10));
//
//        books.add(new PrintedBook("Soft Skills", "John Sonmez", "Career", "9781617292392",
//                "https://m.media-amazon.com/images/I/41Pu-UNFAML.jpg", 7));
//
//        books.add(new PrintedBook("Code Complete", "Steve McConnell", "Software Construction", "9780735619678",
//                "https://m.media-amazon.com/images/I/51WgGoVMT0L.jpg", 8));
//
//        books.add(new PrintedBook("Artificial Intelligence", "Stuart Russell", "AI", "9780136042594",
//                "https://m.media-amazon.com/images/I/51Ymp4MEWjL.jpg", 6));
//
//        books.add(new PrintedBook("Computer Networking", "James F. Kurose", "Networking", "9780133594140",
//                "https://m.media-amazon.com/images/I/71EIgkxWh3L.jpg", 9));
//
//        books.add(new PrintedBook("Python Crash Course", "Eric Matthes", "Programming", "9781593279288",
//                "https://m.media-amazon.com/images/I/81m5QW4ss0L.jpg", 12));
//
//        books.add(new PrintedBook("Deep Learning", "Ian Goodfellow", "AI", "9780262035613",
//                "https://m.media-amazon.com/images/I/71mMl7GqGWL.jpg", 7));
//
//        books.add(new PrintedBook("Database System Concepts", "Abraham Silberschatz", "Databases", "9780073523323",
//                "https://m.media-amazon.com/images/I/51g0C5AUCrL.jpg", 6));
//
//        books.add(new PrintedBook("Learning SQL", "Alan Beaulieu", "Databases", "9780596520830",
//                "https://m.media-amazon.com/images/I/51uVbJbxVhL.jpg", 5));
//
//        for (Book book: books
//             ) {
//            saveEbook(book);
//        }
//        System.out.println("Out done");
    }
    private String getFilePath(){
        return System.getProperty("user.dir")+ File.separator + FILE_NAME;
    }

    public void saveEbook(Book book){
        try{
            File file = new File(getFilePath());

            // Create file if it doesn't exist
            if (!file.exists()) {
                file.createNewFile();
            }

            try(BufferedWriter writer = new BufferedWriter(new FileWriter(getFilePath(),true))){
                writer.write(book.getLine());
                writer.newLine();
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public List<Book> getAllBook(){
        List<Book> books = new ArrayList<>();

        File file = new File(getFilePath());

        if (!file.exists()) return books;

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                String title = parts[0];
                String author = parts[1];
                String genre = parts[2];
                String isbn = parts[3];
                String cover = parts[4];
                if(parts.length==6){
                    int count = Integer.parseInt(parts[5]);
                    books.add(new PrintedBook(title,author,genre,isbn,cover,count));
                }else if(parts.length==7){
                    String fileSize = parts[5];
                    String link = parts[6];
                    books.add(new Ebook(title,author,genre,isbn,cover,fileSize,link));
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return books;
    }

}
