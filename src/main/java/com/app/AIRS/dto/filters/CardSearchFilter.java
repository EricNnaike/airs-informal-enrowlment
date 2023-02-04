package com.app.AIRS.dto.filters;

import com.app.AIRS.entity.QCard;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CardSearchFilter extends BaseSearchDto implements QuerydslBinderCustomizer<QCard> {
    private LocalDate createdAfter;
    private LocalDate createdBefore;

    @Override
    public void customize(QuerydslBindings bindings, QCard root) {
        bindings.bind(root.tin).as("tin").first((path, value) -> path.equalsIgnoreCase(value.trim()));
        bindings.bind(root.cardStatus).as("status").first((path, value) -> path.eq(value));
        bindings.bind(root.cardType).as("cardType").first((path, value) -> path.eq(value));
        bindings.bind(root.phoneNumber).as("phoneNumber").first((path, value) -> path.eq(value));
        bindings.including(root.cardType, root.cardStatus, root.tin);
    }
}
