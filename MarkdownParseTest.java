import static org.junit.Assert.*;
import org.junit.*;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

/* run this when ready on the terminal:
javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java

java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest
*/

public class MarkdownParseTest {

    List<String> strList;
   
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks() throws IOException{
        Path fileName = Path.of("./test-file.md");
        String contents = Files.readString(fileName);
        this.strList = MarkdownParse.getLinks(contents);

        assertEquals(this.strList, List.of("https://something.com", "some-page.html"));
    } 

    @Test
    public void testGetLinks2() throws IOException{
        Path fileName = Path.of("test2-file.md");
        String contents = Files.readString(fileName);
        this.strList = MarkdownParse.getLinks(contents);

        assertEquals(this.strList, List.of());
    }


    @Test
    public void testGetLinks3() throws IOException{
        Path fileName = Path.of("test3-file.md");
        String contents = Files.readString(fileName);
        this.strList = MarkdownParse.getLinks(contents);

        assertEquals(this.strList, List.of("https://hello.com"));
    }

    @Test
    public void testGetLinks4() throws IOException{
        Path fileName = Path.of("test4-file.md");
        String contents = Files.readString(fileName);
        this.strList = MarkdownParse.getLinks(contents);

        assertEquals(this.strList, List.of());
    }

    @Test
    public void testGetLinks5() throws IOException{
        Path fileName = Path.of("test5-file.md");
        String contents = Files.readString(fileName);
        this.strList = MarkdownParse.getLinks(contents);

        assertEquals(List.of(), this.strList);
    }

    @Test
    public void testGetLinks6() throws IOException{
        Path fileName = Path.of("test6-file.md");
        String contents = Files.readString(fileName);
        this.strList = MarkdownParse.getLinks(contents);

        assertEquals(List.of("page.com"), this.strList);
    }

    @Test
    public void testGetLinks7() throws IOException{
        Path fileName = Path.of("test7-file.md");
        String contents = Files.readString(fileName);
        this.strList = MarkdownParse.getLinks(contents);

        assertEquals(List.of(), this.strList);
    }

    @Test
    public void testGetLinks8() throws IOException{
        Path fileName = Path.of("test8-file.md");
        String contents = Files.readString(fileName);
        this.strList = MarkdownParse.getLinks(contents);

        assertEquals(List.of(), this.strList);
    }

    @Test
    public void testGetLinksSnip1() throws IOException{
        Path fileName = Path.of("test-snippet1.md");
        String contents = Files.readString(fileName);
        this.strList = MarkdownParse.getLinks(contents);

        assertEquals(this.strList, List.of("url.com", "`google.com", "google.com"));
    }

    @Test
    public void testGetLinksSnip2() throws IOException{
        Path fileName = Path.of("test-snippet2.md");
        String contents = Files.readString(fileName);
        this.strList = MarkdownParse.getLinks(contents);

        assertEquals(this.strList, List.of("a.com", "a.com(("));
    }

    @Test
    public void testGetLinksSnip3() throws IOException{
        Path fileName = Path.of("test-snippet3.md");
        String contents = Files.readString(fileName);
        this.strList = MarkdownParse.getLinks(contents);

        assertEquals(List.of(), this.strList);
    }

}