package pro_three;

import java.io.IOException;

interface Parser {

    void visit(String sourceInput) throws IOException;

}