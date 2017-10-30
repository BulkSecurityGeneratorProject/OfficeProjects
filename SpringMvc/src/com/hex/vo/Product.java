package com.hex.vo;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTZ")
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "PRODUCTID")
	private Integer productid;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "CATEGORYID")
	private Integer categoryid;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "MANUFACTUREDATE")
	private Date manufacturedate;
	
	@Column(name = "PRICE")
	private Integer price;
	
	@Column(name = "QUANTITY")
	private Integer quantity;
	
	@Column(name = "CREATEDDATE")
	private Date createddate=null;
	
	@Column(name = "CREATEDBY")
	private String createdby="";
	
	@Column(name = "MODIFIEDDATE")
	private Date modifieddate=null;
	
	@Column(name = "MODIFIEDBY")
	private String modifiedby="";


private int hashCode = -1;

	public void setProductid(Integer newValue) { 
		productid = newValue; 
	}

	public Integer getProductid() { 
		return productid;
 	}

	public void setName(String newValue) { 
		name = newValue; 
	}

	public String getName() { 
		return name;
 	}

	public void setCategoryid(Integer newValue) { 
		categoryid = newValue; 
	}

	public Integer getCategoryid() { 
		return categoryid;
 	}

	public void setDescription(String newValue) { 
		description = newValue; 
	}

	public String getDescription() { 
		return description;
 	}

	public void setManufacturedate(Date newValue) { 
		manufacturedate = newValue; 
	}

	public Date getManufacturedate() { 
		return manufacturedate;
 	}

	public void setPrice(Integer newValue) { 
		price = newValue; 
	}

	public Integer getPrice() { 
		return price;
 	}

	public void setQuantity(Integer newValue) { 
		quantity = newValue; 
	}

	public Integer getQuantity() { 
		return quantity;
 	}

	public void setCreateddate(Date newValue) { 
		createddate = newValue; 
	}

	public Date getCreateddate() { 
		return createddate;
 	}

	public void setCreatedby(String newValue) { 
		createdby = newValue; 
	}

	public String getCreatedby() { 
		return createdby;
 	}

	public void setModifieddate(Date newValue) { 
		modifieddate = newValue; 
	}

	public Date getModifieddate() { 
		return modifieddate;
 	}

	public void setModifiedby(String newValue) { 
		modifiedby = newValue; 
	}

	public String getModifiedby() { 
		return modifiedby;
 	}



 private boolean toBeDeleted;

public boolean equals(Object aObj){


return true;

}


public int hashCode(){

return 1;

}

 public void setToBeDeleted(boolean toBeDeleted) {
         this.toBeDeleted = toBeDeleted;
    } 
        public boolean isToBeDeleted() {
            return toBeDeleted;
        }


}
