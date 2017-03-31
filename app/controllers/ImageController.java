package controllers;

import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import java.nio.file.Paths;

import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;


/**
 * Created by SAI PRABHA ANUBHUTI on 11-02-2017.
 */
public class ImageController extends Controller {

    private static final Path IMAGES_ROOT = Paths.get("/Users/hafsafatima/Desktop/MyRepo");
    File uFile;
    public ImageController() {
        uFile = new File(String.valueOf(IMAGES_ROOT));
        if(!uFile.exists()){
            uFile.mkdir();
        }
    }

    public Result uploadImage() {
        Http.MultipartFormData<File> body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart<File> picture = body.getFile("picture");
        if (null == picture) {
            Logger.info("error");
            return badRequest();
        }
        final Path source = picture.getFile().toPath();

        try {
            final String imageId = storeImage(source);
            final String downloadUrl = routes.ImageController.downloadImage(imageId).absoluteURL(request());
            Logger.debug("Download url: {}", downloadUrl);
            return ok(Json.toJson(downloadUrl));
        } catch (IOException e) {
            e.printStackTrace();
            return internalServerError("Failed to store uploaded file");
        }
    }

    public String storeImage(Path source) throws IOException {

        final String imageId = createImageId();
        final Path target = createImagePath(imageId + ".png");

        Logger.debug("source: {} target: {}", source, target);

        Files.move(source, target, REPLACE_EXISTING);
        Logger.debug("Upload file: {}, to path: {}", source, target);

        return imageId;
    }

    private static Path createImagePath(String imageId) {
        return IMAGES_ROOT.resolve(imageId);
    }

    private static String createImageId() {
        final UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public Result downloadImage(String id) {
        final File file = getImage(id);
        if (null == file) {
            return notFound("Image not found");
        }
        return ok(file);
    }

    public File getImage(String id) {

        final File file = createImagePath(id + ".png").toFile();
        if (!file.isFile()) {
            return null;
        }

        return file;
    }

    public Result deleteImage(String id) throws IOException {
        try {
            final Path path = createImagePath(id + ".png");
            if (!path.toFile().isFile()) {
                notFound("Image not found");
            }
            Files.deleteIfExists(path);
            return ok();

        } catch (IOException e) {
            e.printStackTrace();
            return internalServerError("Failed to delete image file");
        }
    }
}
