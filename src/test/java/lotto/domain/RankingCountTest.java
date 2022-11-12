package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankingCountTest {
    RankingCount rankingCount = new RankingCount();

    @BeforeEach
    void setUp() {
        rankingCount.plusRankingCount(Ranking._5TH.name());
        rankingCount.plusRankingCount(Ranking._4TH.name());
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void calculateYieldTest() {
        double yield = rankingCount.calculateYield(10000);
        Assertions.assertThat(yield).isEqualTo(550);
    }

    @Test
    @DisplayName("반올림 할 경우 수익률 계산 테스트")
    void calculateRoundYieldTest() {
        double yield = rankingCount.calculateYield(7000);
        Assertions.assertThat(yield).isEqualTo(785.7);
    }

    @Test
    @DisplayName("반올림 안할 경우 수익률 계산 테스트")
    void calculateNotRoundYieldTest() {
        double yield = rankingCount.calculateYield(6000);
        Assertions.assertThat(yield).isEqualTo(916.7);
    }
}