import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnnotationFinderTest {

    String fakeFile =
                    "public class banan{\n" +
                    "   //jjkjkjkjk\n" +
                    "   @Test\n" +
                    "   @XrayTest(  \"RRCT-001\" )\n" +
                    "   @banan public void method1(){\n" +
                    "   }\n" +
                    "\n" +
                    "   //hjhjhj\n" +
                    "   @XrayTest(\"RRCT-002\")\n" +
                    "\n" +
                    "   @Test\n" +
                    "\n" +
                    "\n" +
                    "   public void method2(){\n" +
                    "   }\n" +
                    "   @Test\n" +
                    "   public void method3(){\n" +
                     "   }\n" +
                    "\n" +
                    "}";

    @Test
    public void findJiraNumbersAndMethodNames(){
        AnnotationFinder an = new AnnotationFinder();
        Map<String, String> result = an.jiraNumbersAndMethodNames(fakeFile);

        assertThat(result.size(), is(2));
        assertThat(result.get("RRCT-001"), is("method1"));
        assertThat(result.get("RRCT-002"), is("method2"));
    }

}