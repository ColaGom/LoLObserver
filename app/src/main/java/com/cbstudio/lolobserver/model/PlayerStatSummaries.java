package com.cbstudio.lolobserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Colabear on 2016-04-07.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerStatSummaries {
    @JsonProperty("playerStatSummaryType")
    private String summaryType;

    @JsonProperty("aggregatedStats")
    private AggregatedStat aggregatedStat;


    @JsonIgnoreProperties(ignoreUnknown = true)
    private class AggregatedStat
    {
        /*
        totalNeutralMinionsKilled
        totalMinionKills
        totalTurretsKilled
        totalNeutralMinionsKilled
        totalMinionKills
        totalChampionKills
        */

        @JsonProperty("totalChampionKills")
        private String totalChampionKill;
        @JsonProperty("totalAssists")
        private String totalAssist;
        @JsonProperty("totalTurretsKilled")
        private String totalTurretsKill;
    }
}
