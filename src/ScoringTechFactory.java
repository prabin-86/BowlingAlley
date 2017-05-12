/**
 * Created by prabinb on 22/04/17.
 */
public class ScoringTechFactory {

    static Scorable giveScoringTech(ScoringType scoringType) {

        if (scoringType == ScoringType.DEFAULT) {
            return new DefaultScoringTechnique();
        }
        return new DefaultScoringTechnique();
    }
}