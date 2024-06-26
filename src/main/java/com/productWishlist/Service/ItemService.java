package com.productWishlist.Service;
import com.productWishlist.CustomException.ItemNotFoundException;
import com.productWishlist.Model.Employee;
import com.productWishlist.Model.Item;
import com.productWishlist.Model.dto.ItemDto;
import com.productWishlist.Model.dto.ResponseItemDto;
import com.productWishlist.Repository.IItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//ItemsService class provides service methods for managing wishlist items

@Service
public class ItemService {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private IItemRepository iItemRepository;

    /**
     * Retrieves all wishlist items for the given user.
     *
     * @param username the username (email) of the user
     * @return a list of ResponseItemDto objects representing wishlist items
     */

    public List<ResponseItemDto> getWishListItems(String username) {

        Employee employee = employeeService.findByEmail(username);
        Optional<List<Item>> itemList = iItemRepository.findByEmployee_Id(employee.getId());
        List<ResponseItemDto> responseItemList = new ArrayList<>();

        if (itemList.isPresent()) {
            for (Item i : itemList.get()) {
                responseItemList.add(new ResponseItemDto(i.getItemId(), i.getItemName(), i.getItemPrice()));
            }
        }
        return responseItemList;
    }
        /**
         * Adds a new item to the user's wishlist.
         *
         * @param username the username (email) of the user
        * @param itemDto  the DTO object representing the item to be added
         * @return an Optional containing the added Item object if successful, or Optional.empty() otherwise
         */
        public Optional<Item> addItem(String username, ItemDto itemDto) {
            Employee employee = employeeService.findByEmail(username);

            if(employee!=null){
                Item item = new Item(itemDto.getName(),itemDto.getPrice(),employee);
                return Optional.of(iItemRepository.save(item));
            }
            else {
                return  Optional.empty();
            }
        }

        /**
         * Deletes an item from the user's wishlist based on its ID.
         *
         * @param id the ID of the item to be deleted
         * @throws ItemNotFoundException if the item with the specified ID is not found
         */
        public void deleteItem(Long id) {

            Optional<Item> item = iItemRepository.findByItemId(id);

            if(item.isPresent())
            {
                iItemRepository.delete(item.get());
            }
            else
            {
                throw new ItemNotFoundException("Item not Found");
            }
        }
    }



