package bladeDemo.controller;

import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.PostRoute;
import com.blade.mvc.http.Request;
import com.blade.mvc.multipart.FileItem;

import java.io.FileOutputStream;
import java.util.Optional;

@Path("req")
public class RequestController {

    @PostRoute("upload")
    public void upload(Request request) {
        Optional<FileItem> fileItem = request.fileItem("img");
        fileItem.ifPresent(item -> {
            System.out.println(item);
            byte[] data = item.getData();
            try {
                FileOutputStream fos = new FileOutputStream("D://test.png");
                fos.write(data);
                fos.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        });
    }
}
