package screen

import LINE_DIVIDER
import extensions.getNotEmptyString

class ShoppingHome : Screen() {
    fun start () {

        showWelcomeMessage()


        showCategories()
    }
        /*
        인사말 출력
     */
        fun showWelcomeMessage() {
            //스택에 저장
            ScreenStack.push(this)
            println("안녕하세요, ShopMall에 오신것을 환영합니다~!")
            println("쇼핑을 계속 하시려면 이름을 입력해 주세요: ")

            val name = readLine().getNotEmptyString() // 화면에서 사용자 입력받기

            println(
                """
            감사합니다. 반갑습니다. $name 님
            원하시는 카테고리를 입력해주세요~ ^^ .
           $LINE_DIVIDER
        """.trimIndent()
            )
        }
        private fun showCategories() {
            val shoppingCategory= ShoppingCategory()

            shoppingCategory.showCategories()
        }



    }





