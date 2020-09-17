package springfive.cms.domain.resources;


import com.google.common.net.HttpHeaders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfive.cms.domain.services.StorageService;

@RestController
@RequestMapping("/api/downloads")
public class DownloadResource {

    @Autowired
    private final StorageService storageService;

    private static final Logger logger = LogManager.getLogger(DownloadResource.class);

    public DownloadResource(StorageService storageService) {
        this.storageService = storageService;
    }


    @GetMapping(value = "/{fileName}")
    public ResponseEntity<Resource> getFile(@PathVariable("fileName") String fileName){
        Resource file = storageService.loadAsResource(fileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment, filename =" +
                file.getFilename()).body(file);

    }

    @PostMapping
    public String postFile(@RequestParam("file") MultipartFile profileFile){

        logger.info(profileFile.getName() + " " + profileFile.getContentType());
        storageService.store(profileFile);
        return("done ! ");

    }
}
