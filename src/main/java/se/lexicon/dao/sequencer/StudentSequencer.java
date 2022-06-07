package se.lexicon.dao.sequencer;

public class StudentSequencer {
    private static int sequencer=0;

    public static int NextId(){
        return ++sequencer;
    }
}
