import com.cs.fx.service.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Tomasz on 06.07.2017.
 */
public class DeserializationTest {

    private JacksonTester<SpotTradeDto> spotJson;
    private JacksonTester<ForwardTradeDto> forwardJson;
    private JacksonTester<VanillaOptionTradeDto> optionJson;
    private JacksonTester<List<FxTradeDto>> fxTradesJson;

    @Before
    public void setup() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JodaModule());
        // Possibly configure the mapper
        JacksonTester.initFields(this, objectMapper);
    }

    @Test
    public void ensureSpotTradeSampleDeserializes() throws IOException {
        // arrange
        String content = SampleUtil.loadSample("sample-spot-trade.json");

        // act
        SpotTradeDto trade = spotJson.parseObject(content);

        // assert
        assertThat(trade.getCustomer()).isEqualTo("PLUTO1");
        assertThat(trade.getLegalEntity()).isEqualTo("CS Zurich");
        assertThat(trade.getTrader()).isEqualTo("Johann Baumfiddler");

        assertThat(trade.getType()).isEqualTo("Spot");
        assertThat(trade.getCcyPair()).isEqualTo("EURUSD");
        assertThat(trade.getDirection()).isEqualTo(TradeDirection.BUY);

        assertThat(trade.getTradeDate()).isEqualTo(new DateTime("2016-08-11", DateTimeZone.UTC));
        assertThat(trade.getValueDate()).isEqualTo(new DateTime("2016-08-15", DateTimeZone.UTC));
        assertThat(trade.getAmount1()).isEqualTo(new BigDecimal("1000000.00"));
        assertThat(trade.getAmount2()).isEqualTo(new BigDecimal("1120000.00"));
        assertThat(trade.getRate()).isEqualTo(new BigDecimal("1.12"));
    }

    @Test
    public void ensureForwardTradeSampleDeserializes() throws IOException {
        // arrange
        String content = SampleUtil.loadSample("sample-forward-trade.json");

        // act
        ForwardTradeDto trade = forwardJson.parseObject(content);

        // assert
        assertThat(trade.getCustomer()).isEqualTo("PLUTO2");
        assertThat(trade.getLegalEntity()).isEqualTo("CS Zurich");
        assertThat(trade.getTrader()).isEqualTo("Johann Baumfiddler");

        assertThat(trade.getType()).isEqualTo("Forward");
        assertThat(trade.getCcyPair()).isEqualTo("EURUSD");
        assertThat(trade.getDirection()).isEqualTo(TradeDirection.BUY);

        assertThat(trade.getTradeDate()).isEqualTo(new DateTime("2016-08-11", DateTimeZone.UTC));
        assertThat(trade.getValueDate()).isEqualTo(new DateTime("2016-08-21", DateTimeZone.UTC));
        assertThat(trade.getAmount1()).isEqualTo(new BigDecimal("1000000.00"));
        assertThat(trade.getAmount2()).isEqualTo(new BigDecimal("1120000.00"));
        assertThat(trade.getRate()).isEqualTo(new BigDecimal("1.12"));
    }

    @Test
    public void ensureVanillaOptionTradeSampleDeserializes() throws IOException {
        // arrange
        String content = SampleUtil.loadSample("sample-vanillaoption-trade.json");

        // act
        VanillaOptionTradeDto trade = optionJson.parseObject(content);

        // assert
        assertThat(trade.getCustomer()).isEqualTo("PLUTO1");
        assertThat(trade.getLegalEntity()).isEqualTo("CS Zurich");
        assertThat(trade.getTrader()).isEqualTo("Johann Baumfiddler");

        assertThat(trade.getType()).isEqualTo("VanillaOption");
        assertThat(trade.getCcyPair()).isEqualTo("EURUSD");
        assertThat(trade.getDirection()).isEqualTo(TradeDirection.BUY);

        assertThat(trade.getTradeDate()).isEqualTo(new DateTime("2016-08-11", DateTimeZone.UTC));
        assertThat(trade.getAmount1()).isEqualTo(new BigDecimal("1000000.00"));
        assertThat(trade.getAmount2()).isEqualTo(new BigDecimal("1120000.00"));
        assertThat(trade.getRate()).isEqualTo(new BigDecimal("1.12"));

        assertThat(trade.getStyle()).isEqualTo(OptionStyle.EUROPEAN);
        assertThat(trade.getStrategy()).isEqualTo(OptionStrategy.CALL);

        assertThat(trade.getDeliveryDate()).isEqualTo(new DateTime("2016-08-22", DateTimeZone.UTC));
        assertThat(trade.getExpiryDate()).isEqualTo(new DateTime("2016-08-19", DateTimeZone.UTC));
        assertThat(trade.getPayCcy()).isEqualTo("USD");
        assertThat(trade.getPremium()).isEqualTo(new BigDecimal("0.20"));
        assertThat(trade.getPremiumCcy()).isEqualTo("USD");
        assertThat(trade.getPremiumType()).isEqualTo("%USD");
        assertThat(trade.getPremiumDate()).isEqualTo(new DateTime("2016-08-12", DateTimeZone.UTC));
    }

    @Test
    public void ensurePolymorphismWorksAndDeserializes() throws IOException {
        // arrange
        String content = SampleUtil.loadSample("sample-trade-data.json");

        // act
        List<FxTradeDto> fxTrades = fxTradesJson.parseObject(content);

        // assert
        assertThat(fxTrades.size()).isEqualTo(15);

        // 2 spots, 5 forwards, 8 options
        int i = 0;
        for(int j = 0; j < 2; j++) {
            assertThat(fxTrades.get(i)).isExactlyInstanceOf(SpotTradeDto.class);
            i++;
        }
        for(int j = 0; j < 5; j++) {
            assertThat(fxTrades.get(i)).isExactlyInstanceOf(ForwardTradeDto.class);
            i++;
        }
        for(int j = 0; j < 8; j++) {
            assertThat(fxTrades.get(i)).isExactlyInstanceOf(VanillaOptionTradeDto.class);
            i++;
        }
    }
}

