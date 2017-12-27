import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnnotationFinder {

    public static final String PATTERN = "[\\n\\r].*@XrayTest\\s*\\(\\s*\\\"([a-zA-Z]+-\\d+)\\\"\\s*\\).*[\\n\\r]*.*[\\n\\r]*.*public\\s+void\\s+(\\w+)";
    private Pattern pattern = Pattern.compile(PATTERN);


    public Map<String,String> jiraNumbersAndMethodNames(String src) {
        Matcher matcher = pattern.matcher(src);

        Map<String,String> result = new HashMap();
        while(matcher.find()){
                String jira = matcher.group(1);
                String method = matcher.group(2);
                result.put(jira, method);
        }
        return result;
    }
}
