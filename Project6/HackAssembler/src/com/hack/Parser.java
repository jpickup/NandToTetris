package com.hack;

import com.hack.token.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {

    public List<Token> parse(File assemblerFile) throws IOException {
        try (Stream<String> stream = Files.lines(assemblerFile.toPath())) {
            return stream.map(String::trim).map(this::parseLine).filter(Objects::nonNull).collect(Collectors.toList());
        }
    }

    private static final Pattern literalPattern = Pattern.compile("@([0-9]+)$");
    private static final Pattern symbolPattern = Pattern.compile("@([a-zA-Z_][a-zA-Z_0-9.$]*)$");
    private static final Pattern assignmentPattern = Pattern.compile("([A|D|M]+)=([ADM01\\-+&|!]+)$");
    private static final Pattern jumpPattern = Pattern.compile("([A|D|M|0]);(JMP|JGT|JEQ|JLT|JGE|JLE|JNE|NULL)$");
    private static final Pattern labelPattern = Pattern.compile("\\(([a-zA-Z_0-9.$]+)\\)$");

    private Token parseLine(String line) {
        if (line.isBlank()) return null;
        if (line.startsWith("//")) return null;
        line = line.replaceAll("\\s", "");      // remove any whitespace
        Matcher literalMatcher = literalPattern.matcher(line);
        Matcher symbolMatcher = symbolPattern.matcher(line);
        Matcher assignmentMatcher = assignmentPattern.matcher(line);
        Matcher jumpMatcher = jumpPattern.matcher(line);
        Matcher labelMatcher = labelPattern.matcher(line);

        if (literalMatcher.matches()) return literal(literalMatcher);
        if (symbolMatcher.matches()) return symbol(symbolMatcher);
        if (assignmentMatcher.matches()) return assignment(assignmentMatcher);
        if (jumpMatcher.matches()) return jump(jumpMatcher);
        if (labelMatcher.matches()) return label(labelMatcher);
        throw new ParserException("Unrecognised input " + line);
    }

    private Token literal(Matcher matcher) {
        return new Literal(matcher.group(1));
    }
    private Token symbol(Matcher matcher) {
        return new Symbol(matcher.group(1));
    }
    private Token assignment(Matcher matcher) {
        return new Assignment(matcher);
    }
    private Token jump(Matcher matcher) {
        return new Jump(matcher);
    }
    private Token label(Matcher matcher) {
        return new Label(matcher);
    }
}
