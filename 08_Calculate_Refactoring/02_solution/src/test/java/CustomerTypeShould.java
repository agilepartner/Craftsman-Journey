import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTypeShould {
    @Test
    void allow_0_discount_for_not_registered_customers() {
        assertThat(CustomerType.NOT_REGISTERED.discount(1)).isEqualTo(0.0);
        assertThat(CustomerType.NOT_REGISTERED.discount(3)).isEqualTo(0.0);
        assertThat(CustomerType.NOT_REGISTERED.discount(5)).isEqualTo(0.0);
        assertThat(CustomerType.NOT_REGISTERED.discount(10)).isEqualTo(0.0);
    }

    @Test
    void allow_a_ratio_of_0_for_not_registered_customers() {
        assertThat(CustomerType.NOT_REGISTERED.ratio()).isEqualTo(0.0);
    }

    @Test
    void allow_yearly_discount_with_a_max_of_5_years_for_simple_customers() {
        assertThat(CustomerType.SIMPLE.discount(1)).isEqualTo(0.01);
        assertThat(CustomerType.SIMPLE.discount(3)).isEqualTo(0.03);
        assertThat(CustomerType.SIMPLE.discount(5)).isEqualTo(0.05);
        assertThat(CustomerType.SIMPLE.discount(10)).isEqualTo(0.05);
    }

    @Test
    void allow_a_ratio_of_0_1_for_simple_customers() {
        assertThat(CustomerType.SIMPLE.ratio()).isEqualTo(0.1);
    }

    @Test
    void allow_yearly_discount_with_a_max_of_5_years_for_valuable_customers() {
        assertThat(CustomerType.VALUABLE.discount(1)).isEqualTo(0.01);
        assertThat(CustomerType.VALUABLE.discount(3)).isEqualTo(0.03);
        assertThat(CustomerType.VALUABLE.discount(5)).isEqualTo(0.05);
        assertThat(CustomerType.VALUABLE.discount(10)).isEqualTo(0.05);
    }

    @Test
    void allow_a_ratio_of_0_3_for_valuable_customers() {
        assertThat(CustomerType.VALUABLE.ratio()).isEqualTo(0.3);
    }

    @Test
    void allow_yearly_discount_with_a_max_of_5_years_for_most_valuable_customers() {
        assertThat(CustomerType.MOST_VALUABLE.discount(1)).isEqualTo(0.01);
        assertThat(CustomerType.MOST_VALUABLE.discount(3)).isEqualTo(0.03);
        assertThat(CustomerType.MOST_VALUABLE.discount(5)).isEqualTo(0.05);
        assertThat(CustomerType.MOST_VALUABLE.discount(10)).isEqualTo(0.05);
    }

    @Test
    void allow_a_ratio_of_0_5_for_most_valuable_customers() {
        assertThat(CustomerType.MOST_VALUABLE.ratio()).isEqualTo(0.5);
    }
}
