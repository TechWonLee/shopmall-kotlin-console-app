package screen

import extensions.getNotEmptyString

class ShoppingCategory {
    fun showCategories() {

        val categories = arrayOf("패션", "전자기기", "반려동물용품")
        for (category in categories) {
            println(category)
        }
        println("==> 장바구니로 이동하시려면 '#'을 입력해주세요 ")

        // 카테고리 입력 받기
        // readLine()의 반환타입이 String?이므로 확장함수 사용 가능
        var selectedCategory = readLine().getNotEmptyString()

        /*
        // 사용자가 올바른 입력을할때까지 반복처리
        while (selectedCategory.isNullOrBlank()) {
            println("값을 입력해 주세요!")
            selectedCategory = readLine()
        }
        */


        if (selectedCategory == "#") {
            // (1) 장바구니로 이동
            val shoppingCart= ShoppingCart()
            shoppingCart.showCartItems()
        } else {
            if(categories.contains(selectedCategory)) {
                // 카테고리 상품 목록 보여주기
                val shoppingProductList = ShoppingProductList()
                shoppingProductList.showProducts(selectedCategory)
            }else{
                //  (3) 카테고리 목록에 없는 경우 처리
                showErrorMessage(selectedCategory)
            }

        }
    }

    private fun showErrorMessage(selectedCategory: String?) {
        println("[$selectedCategory]: 존재하지 않는 카테고리 입니다. 다시 입력해 주세요~!")
        showCategories()
    }
}