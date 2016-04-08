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
        @JsonProperty("totalChampionKills")
        private String totalChampionKills;
        @JsonProperty("totalAssists")
        private String totalAssists;
        @JsonProperty("totalTurretsKilled")
        private String totalTurretsKilled;
        @JsonProperty("totalNeutralMinionsKilled")
        private String totalNeutralMinionsKilled;
        @JsonProperty("totalMinionKills")
        private String totalMinionKills;
    }
}
