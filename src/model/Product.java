package model;

import java.time.LocalDateTime;

public abstract class Product {
	protected int id;
	protected String productName;
	protected String discription;
	protected LocalDateTime manufDate;
	protected LocalDateTime disqDate;
	protected long price;	
}
