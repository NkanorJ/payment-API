package paymentassesment.paymentcontroller.usecase

import com.assesment.paymentassesment.dao.PaymentRepository
import com.assesment.paymentassesment.dto.PaymentRequest
import com.assesment.paymentassesment.dto.PaymentResponseDto
import com.assesment.paymentassesment.enumeration.PaymentType
import com.assesment.paymentassesment.factory.PaymentFactory
import com.assesment.paymentassesment.parsers.CardParser
import com.assesment.paymentassesment.service.PaymentService
import com.assesment.paymentassesment.usecase.PaymentStorage
import spock.lang.Shared
import spock.lang.Specification

class PaymentUseCaseTest extends Specification {

    @Shared
    def paymentRepositoryMock = Mock(PaymentRepository)

    def paymentStorage = Mock(PaymentStorage)

    def setup() {
        def paymentFactory = new PaymentFactory([new CardParser()])
        paymentStorage = new PaymentService(paymentFactory, paymentRepositoryMock)
    }

    def "should make card payment successfully"() {
        given:
        def paymentRequest = new PaymentRequest(
                "543215678005321",
                "janeetim248@gmail.com",
                "123",
                100.0,
                "12/45",
                Currency.getInstance("NGN"),
                PaymentType.CARD,
                "07060482184"
        )

        when:
        def paymentResponse = paymentStorage.makePayment(paymentRequest)

        then:
        paymentResponse.status() == "Payment successful"
    }


    def "should get all payments successfully"() {
        given:
        paymentRepositoryMock = Mock(PaymentRepository)
        def expectedPaymentData = [
                new PaymentResponseDto(
                        1L, "janeetim248@gmail.com", "123", BigDecimal.valueOf(100.00), "12/45",
                        Currency.getInstance("NGN"), PaymentType.CARD, "07060482184"
                ),
                new PaymentResponseDto(
                        2L, "janeetim248@gmail.com", "123", BigDecimal.valueOf(200.00), "12/24",
                        Currency.getInstance("NGN"), PaymentType.CARD, "07060482184"
                )
        ]
        paymentRepositoryMock.getAllPayment() >> expectedPaymentData

        when:
        def response = paymentStorage.getAllPayment()

        then:
        response.responseMessage == "Data Fetched Successfully"
    }
}
