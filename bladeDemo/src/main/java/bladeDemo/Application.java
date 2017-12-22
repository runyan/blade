package bladeDemo;

import com.blade.Blade;

public class Application {

    public static void main(String[] args) {
        Blade.me()
//                .listen(9090)
                .get("/", (req, res) -> res.text("hello blade"))
                .start(Application.class);
    }

}
