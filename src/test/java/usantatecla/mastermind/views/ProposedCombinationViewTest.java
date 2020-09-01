package usantatecla.mastermind.views;

import usantatecla.utils.Console;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import usantatecla.mastermind.controllers.*;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;

@RunWith(MockitoJUnitRunner.class)
public class ProposedCombinationViewTest {
    
    @Mock
    Console console;

    @InjectMocks
    ProposedCombinationView ProposedCombitanionView = new ProposedCombinationView(new PlayController(new Session()));
  
    @Test
    public void testGivenAProposedCombinationWhenReadThenIsCorrect() {
        when(this.console.readString("Propose a combination: ")).thenReturn("ybop");
        List<Color> proposedCombination = this.ProposedCombitanionView.read();
        List<Color> proposedCombinationExpected = new ArrayList<Color>();
        proposedCombinationExpected.add(Color.YELLOW);
        proposedCombinationExpected.add(Color.BLUE);
        proposedCombinationExpected.add(Color.ORANGE);
        proposedCombinationExpected.add(Color.PURPLE);
        assertEquals(proposedCombination.get(0), proposedCombinationExpected.get(0));
        assertEquals(proposedCombination.get(1), proposedCombinationExpected.get(1));
        assertEquals(proposedCombination.get(2), proposedCombinationExpected.get(2));
        assertEquals(proposedCombination.get(3), proposedCombinationExpected.get(3));
    }

    @Test
    public void testGivenAProposedCombinationWhenReadThenIsIncorrect() {
        when(this.console.readString("Propose a combination: ")).thenReturn("yyop");
        this.ProposedCombitanionView.read();
        verify(this.console).readString("Propose a combination: ");
    }

}