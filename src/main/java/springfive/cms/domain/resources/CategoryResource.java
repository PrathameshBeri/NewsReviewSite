package springfive.cms.domain.resources;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfive.cms.domain.models.Category;
import springfive.cms.domain.service.CategoryService;
import springfive.cms.vo.CategoryRequest;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/category")
@Api(tags = "category", description = "Category.API")
public class CategoryResource {

    private static final Logger logger = LogManager.getLogger(CategoryResource.class);
    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find category", notes = "Find the Category by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category found"),
            @ApiResponse(code = 404, message = "Catgory not found")

    })
    public ResponseEntity<Category> findOne(@PathVariable("id") String id){

        return null;
    }

    @GetMapping
    @ApiOperation(value = "Find all categories", notes = "List all categories")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Categories found"),
            @ApiResponse(code = 404, message = "No Category not found")

    })
    public ResponseEntity<List<Category>> findAll(){
        logger.info("BERI In get all method");
        List<Category> cats = categoryService.findAll();

        return ResponseEntity.ok(cats);
    }

    @PostMapping
    @ApiOperation(value = "Create categories", notes = "It permits to create a category")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Category found"),
            @ApiResponse(code = 404, message = "Catgory not found")

    })
    public ResponseEntity<Category> addCategory(CategoryRequest category){

        Category cat = new Category(category.getName());
        categoryService.create(cat);
        return new ResponseEntity<>(cat, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete categories", notes = "It can delete a category")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category deleted successfully"),
            @ApiResponse(code = 404, message = "Category not found")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCategory(@PathVariable("id") String id){



    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update a category", notes = "This can update a category")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Category updated"),
            @ApiResponse(code = 404, message = "Category not found"),
            @ApiResponse(code = 401, message = "Invalid Request")
    })
    public ResponseEntity<Category> updateCategory(@PathVariable("id") String id, CategoryRequest category){

        return new ResponseEntity<>(null, HttpStatus.OK);
    }



}
