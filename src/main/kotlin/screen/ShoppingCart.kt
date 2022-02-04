package screen

import LINE_DIVIDER
import data.CartItems

/*
    장바구니의 내용을 화면에 출력
 */

class ShoppingCart : Screen() {

    private val products = CartItems.products // 장바구니에 담겨있는 상품목록 변수

    fun showCartItems() {
        //스택에 저장
        ScreenStack.push(this)

        if (products.isNotEmpty()) {
            // 장바구니 상품 목록 출력
            println(
                products.keys.joinToString(
                    separator = ", \n",
                    prefix = """
                            $LINE_DIVIDER
                            장바구니에 담긴 상품 목록입니다.
                              """.trimIndent()
                ) { product ->
                    "카테고리: ${product.categoryLabel} / 상품명: ${product.name} / 수량: ${products[product]}"

                }
            )
        } else {
            println(
                """
                장바구니에 담긴 상품이 없습니다.
            """.trimIndent()
            )
        }

    }
}