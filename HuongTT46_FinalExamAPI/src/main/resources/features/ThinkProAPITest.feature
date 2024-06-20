Feature: Think Pro API
  Scenario: Retrieve all products under 'ban-phim' category
    Given Call API product-items to get all products of ban-phim
    When Extract all product items with some information (product_id, category_id, slug, name, brand id, brand name, price).
    And  Call API product-items compare to compare random 2 products in list already extract at above step
    Then Verify API product-items compare should be return two products and product information must be correct for product_id, category_id, slug, name, brand id, brand name, price

