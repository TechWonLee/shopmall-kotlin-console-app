package screen

import data.CartItems
import data.Product
import extensions.getNotEmptyInt
import extensions.getNotEmptyString

class ShoppingProductList {

    private val products = arrayOf(
        Product("패션", "겨울패딩"),
        Product("패션", "겨울바지"),
        Product("전자기기", "핸드폰"),
        Product("전자기기", "블루투스 이어폰"),
        Product("전자기기", "노트북"),
        Product("반려동물용품", "건식사료"),
        Product("반려동물용품", "습식사료"),
        Product("반려동물용품", "치약"),
        Product("반려동물용품", "간식"),
    )

    /*
        카테고리별 상품목록 변수 저장

        패션 - ("패션","겨울패딩"),("패션","겨울바지")
        전자기기 - ("전자기기","핸드폰"),("전자기기","블루투스 이어폰")
     */
    private val categories: Map<String, List<Product>> =
        products.groupBy { products ->
            products.categoryLabel
        }

    /*
        사용자가 입력한 카테고리 정보를 받아 해당 카테고리의 상품을 출력하는 함수
     */
    fun showProducts(selectedCategory: String) {

        // 지정된 카테고리의 상품목록을 가져온다.
        val categoryProducts = categories[selectedCategory] // 키: selectedCategory

        // 가져온 상품목록이 비어있지 않으면
        if (!categoryProducts.isNullOrEmpty()) {
            println(
                """
                ------------------------------
                
                선택하신 [$selectedCategory] 카테고리 상품입니다.
                
                ------------------------------
            """.trimIndent()
            )

            /*
            val productsize = categoryProducts.size // 각 카테고리의 size를 담는 변수

            for (index in 0 until productsize) {
                println("${index}.${categoryProducts[index].name}")
            }
            */

            categoryProducts.forEachIndexed { index, product ->
                println("${index}. ${product.name}")
            }

            // 장바구니에 담을 상품 선택
            showCartOption(categoryProducts, selectedCategory)
        } else {
            showEmptyProductMessage(selectedCategory)
        }
    }

    private fun showCartOption(categoryProducts: List<Product>, selectedCategory: String) {

        println(
            """
             ------------------------------
             
             장바구니에 담을 상품 번호를 선택해 주세요

        """.trimIndent()
        )

        // 상품 번호 입력수행
        val selectedIndex = readLine().getNotEmptyInt()

        categoryProducts.getOrNull(selectedIndex)?.let { product ->
            CartItems.addProduct(product)
            println("=> 장바구니로 이동하시려면 #을, 계속 쇼핑하려면 * 입력해 주세요")

            val answer = readLine().getNotEmptyString()

            if (answer == "#") {
                val shoppingCart = ShoppingCart()
                shoppingCart.showCartItems()
            } else if (answer == "*") {
                showProducts(selectedCategory)
            } else {

            }
        }
    }

    private fun showEmptyProductMessage(selectedCategory: String) {
        println("[$selectedCategory] 카테고리 상품이 등록되기 전입니다.")
    }
}