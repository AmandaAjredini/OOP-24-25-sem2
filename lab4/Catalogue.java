public class Catalogue {
    public FoodProduct[] foodProducts;
    public ClothingProduct[] clothingProducts;

    public Catalogue(String[][] food, String[][] clothing) {
        this.foodProducts = new FoodProduct[food.length];
        this.clothingProducts = new ClothingProduct[clothing.length];

        for (int i = 0; i < food.length; i++) {
            foodProducts[i] = new FoodProduct(food[i][0], food[i][1], food[i][2], food[i][3]);
        }

        for (int i = 0; i < clothing.length; i++) {
             clothingProducts[i] = new ClothingProduct(clothing[i][0], clothing[i][1], clothing[i][2], clothing[i][3]);
        }
    }

    public Product getProductByName(String name) {
        for (FoodProduct food : foodProducts) {
            if (food.name.equals(name)) {
                return food;
            }
        }

        for (ClothingProduct clothing : clothingProducts) {
            if (clothing.name.equals(name)) {
                return clothing;
            }
        }

        return null; // If no matches then not found (null)
    }
}
