

CREATE TABLE Location (
Location_ID INT NOT NULL, 
Location_name varchar (50), 
PRIMARY KEY (Location_ID)
);

CREATE TABLE Player (
Player_ID int auto_increment,
Jarl_level_count_ID INT,
Player_Name varchar (50),
Player_health INT (10), 
Player_attack_damage INT (10), 
Player_armor INT (10), 
Player_bank INT (10),
PRIMARY KEY (Player_ID)
);

CREATE TABLE Quest (
Quest_ID INT NOT NULL,
Quest_name varchar (50),
primary_objective varchar (50), 
secondary_objective_1 varchar (50), 
secondary_objective_2 varchar (50), 
primary key (Quest_ID)
);
CREATE TABLE Side_Quests (
Side_Quest_ID INT,
Side_Quest_name varchar (50),
Side_quest_primary_objective varchar (50),
PRIMARY KEY (Side_Quest_ID)
);

CREATE TABLE Quest_location_mapping (
Quest_ID INT NOT NULL, 
Location_ID INT NOT NULL, 
Location_Completion bit NOT NULL, 
PRIMARY KEY (Location_ID,Quest_ID),
FOREIGN KEY (Location_ID) REFERENCES Location(Location_ID), 
FOREIGN KEY (Quest_ID) REFERENCES Quest(Quest_ID) 
);


CREATE TABLE Save (
Player_ID INT auto_increment,
Playtime INT NOT NULL, 
Side_Quest_ID INT,

PRIMARY KEY (Player_ID), 
FOREIGN KEY (Player_ID) REFERENCES Player(Player_ID)
);

CREATE TABLE Play_Location_mapping (
Player_ID INT auto_increment, 
Location_ID INT NOT NULL,
Location_Completion bit NOT NULL, 
Side_Quest_ID INT NOT NULL, 
Side_quest_completion bit,
Primary key (Player_ID), 
FOREIGN KEY (Side_Quest_ID) REFERENCES Side_Quests(Side_Quest_ID),

FOREIGN KEY (Player_ID) REFERENCES Save(Player_ID),
FOREIGN KEY (Location_ID) REFERENCES Location(Location_ID)
);



CREATE TABLE Gooditems (
Item_ID INT NOT NULL, 
Item_name varchar (50), 
Description varchar (200),
Health_value INT (10),
cost INT (10),
PRIMARY KEY (Item_ID)
); 

CREATE TABLE Store_good_items (
Item_ID INT NOT NULL, 
Item_name varchar (50), 
Description varchar (200),
Health_value INT (10),
cost INT (10),
PRIMARY KEY (Item_ID), 
FOREIGN KEY (Item_ID) REFERENCES Gooditems (Item_ID)
);



CREATE TABLE weapon_item (
weapon_ID INT NOT NULL, 
weapon_name varchar (50), 
Description varchar (130),
attack_value INT (10),
cost INT (10),
PRIMARY KEY (weapon_ID)

);

CREATE TABLE store_weapon_item (
weapon_ID INT NOT NULL, 
weapon_name varchar (50), 
Description varchar (130),
attack_value INT (10),
cost INT (10),
PRIMARY KEY (weapon_ID),
FOREIGN KEY (weapon_ID) REFERENCES weapon_item (weapon_ID)
);

CREATE TABLE Armor (
Armor_ID INT NOT NULL, 
Armor_name varchar (50), 
Description varchar (130),
armor_value INT (10),
cost INT (10),
PRIMARY KEY (Armor_ID)
);

CREATE TABLE Store_Armor (
Armor_ID INT NOT NULL, 
Armor_name varchar (50), 
Description varchar (130),
armor_value INT (10),
cost INT (10),
PRIMARY KEY (Armor_ID),
FOREIGN KEY (Armor_ID) REFERENCES Armor (Armor_ID)
);
