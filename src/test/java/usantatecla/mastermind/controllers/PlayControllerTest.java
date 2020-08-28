package usantatecla.mastermind.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import usantatecla.mastermind.types.Color;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


import usantatecla.mastermind.models.Session;

public class PlayControllerTest {
    private PlayController playController;
    private Session session;

    public PlayControllerTest() {
        this.session = new Session();
        this.playController = new PlayController(session);
    }

    @Test
    public void testIsWinnerAtTheGameBeginsThenIsFalse(){
        assertFalse(this.playController.isWinner());
    }

    @Test
    public void testGetAttempsAtTheGameBeginsThenIs1(){
        assertEquals(this.playController.getAttempts(),0);
    }
    @Test
    public void testRedoableAtTheGameBeginsThenIsFalse(){
        assertFalse(this.playController.redoable());
    }
    @Test
    public void testUndoableAtTheGameBeginsThenIsFalse(){
        assertFalse(this.playController.undoable());
    }
    @Test
    public void testGetWhitesAfterProposeCombination(){
        List<Color> colors = this.playController.session.getSecretCombination();
        this.playController.addProposedCombination(colors);
        assertEquals(0, this.playController.getWhites(0));
    }
    @Test
    public void testGetBlacksAfterProposeCombination(){
        List<Color> colors = this.playController.session.getSecretCombination();
        this.playController.addProposedCombination(colors);
        assertEquals(4, this.playController.getBlacks(0));
    }
}