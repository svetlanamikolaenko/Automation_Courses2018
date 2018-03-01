package lesson15;

import org.testng.annotations.Test;

import java.io.IOException;

public class TestTrelloApi {
    @Test
    public void testGetBoardList() throws IOException {
        TrelloApiNew trelloApiNew = new TrelloApiNew();
        String boardList = trelloApiNew.getBoardList("U7rGkWwP");
        String boardLables = trelloApiNew.getBoardLabel("U7rGkWwP");
        System.out.println(boardList);
        System.out.println(boardLables);
        }
    }

