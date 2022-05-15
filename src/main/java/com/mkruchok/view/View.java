package com.mkruchok.view;

import com.mkruchok.controller.implementation.*;
import com.mkruchok.model.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public final class View {
    private static final Scanner SCANNER = new Scanner(System.in, "UTF-8");
    private final Map<String, Printable> menu = new LinkedHashMap<>();

    private final HubController hubController = new HubController();
    private final DeviceController deviceController = new DeviceController();
    private final NotificationController notificationController = new NotificationController();
    private final GroupController groupController = new GroupController();
    private final PermissionController permissionController = new PermissionController();
    private final UserController userController = new UserController();
    private final RexController rexController = new RexController();
    static final Logger LOGGER = LoggerFactory.getLogger(View.class);


    public View() {
        menu.put("11", this::getAllUsers);
        menu.put("12", this::getUserById);
        menu.put("13", this::createUser);
        menu.put("14", this::updateUser);
        menu.put("15", this::deleteUser);

        menu.put("21", this::getAllHubs);
        menu.put("22", this::getHubById);
        menu.put("23", this::createHub);
        menu.put("24", this::updateHub);
        menu.put("25", this::deleteHub);

        menu.put("31", this::getAllDevices);
        menu.put("32", this::getDeviceByName);
        menu.put("33", this::createDevice);
        menu.put("34", this::updateDevice);
        menu.put("35", this::deleteDevice);

        menu.put("41", this::getAllNotifications);
        menu.put("42", this::getNotificationById);
        menu.put("43", this::createNotification);
        menu.put("44", this::updateNotification);
        menu.put("45", this::deleteNotification);

        menu.put("51", this::getAllGroups);
        menu.put("52", this::getGroupById);
        menu.put("53", this::createGroup);
        menu.put("54", this::updateGroup);
        menu.put("55", this::deleteGroup);

        menu.put("61", this::getAllPermissions);
        menu.put("62", this::getPermissionById);
        menu.put("63", this::createPermission);
        menu.put("64", this::updatePermission);
        menu.put("65", this::deletePermission);

        menu.put("71", this::getAllRexes);
        menu.put("72", this::getRexById);
        menu.put("73", this::createRex);
        menu.put("74", this::updateRex);
        menu.put("75", this::deleteRex);
    }

    public void show() {
        String input;
        Menu showMenu = new Menu();
        showMenu.displayMenu();
        LOGGER.debug("\nEnter numbers:\n");
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception e) {
                LOGGER.debug("\nSomething is not right...\n");
            }
        } while (SCANNER.hasNext());
    }

    private void getAllUsers() throws SQLException {

        LOGGER.debug(userController.findAll().toString());
    }

    private void getUserById() throws SQLException {
        LOGGER.debug("\nEnter iD: ");
        Integer id = SCANNER.nextInt();
        LOGGER.debug(userController.findById(id).toString());
    }

    private User getUserInputs(Integer create) {
        LOGGER.debug("Enter email: ");
        String email = SCANNER.next();
        LOGGER.debug("Enter password: ");
        String password = SCANNER.next();
        LOGGER.debug("Enter name: ");
        String name = SCANNER.next();
        Timestamp dateCreated = new Timestamp(System.currentTimeMillis());
        String groupId = null;
        if (create == 0) {
            LOGGER.debug("Enter group id: ");
            groupId = SCANNER.next();
        }
        return new User(email, password, dateCreated, name, groupId);
    }

    private void createUser() throws SQLException {
        
        User user = getUserInputs(1);
        userController.create(user);
        LOGGER.debug("User was added to the table.\nEnter numbers: ");
    }

    private void updateUser() throws SQLException {
        LOGGER.debug("\nEnter id to updаte: ");
        Integer id = SCANNER.nextInt();
        User user = getUserInputs(0);
        user.setId(id);
        userController.update(user.getId(), user);
        LOGGER.debug("Updated user, id = " + id);
    }

    private void deleteUser() throws SQLException {
        LOGGER.debug("\nEnter ID to delete user: ");
        int id = SCANNER.nextInt();
        userController.delete(id);
        LOGGER.debug("Deleted user, id = " + id);
    }


    private void getAllHubs() throws SQLException {
        
        LOGGER.debug(hubController.findAll().toString());
    }

    private void getHubById() throws SQLException {
        LOGGER.debug("\nEnter Id: ");
        Integer id = SCANNER.nextInt();
        LOGGER.debug(hubController.findById(id).toString());
    }

    private Hub getHubInputs() {
        LOGGER.debug("\nEnter model: ");
        String model = SCANNER.next();
        LOGGER.debug("Enter status: ");
        String status = SCANNER.next();
        SCANNER.nextLine();
        LOGGER.debug("Enter service_life_end_time: ");
        Timestamp serviceLifeEndTime = Timestamp.valueOf(SCANNER.nextLine());
        LOGGER.debug("Enter warranty_end_time: ");
        Timestamp warrantyEndTime = Timestamp.valueOf(SCANNER.nextLine());
        LOGGER.debug("Enter users_max: ");
        Integer usersMax = SCANNER.nextInt();
        LOGGER.debug("Enter rooms_max: ");
        Integer roomsMax = SCANNER.nextInt();
        LOGGER.debug("Enter devices_max: ");
        Integer devicesMax = SCANNER.nextInt();
        LOGGER.debug("Enter sirens_max: ");
        Integer sirensMax = SCANNER.nextInt();
        LOGGER.debug("Enter on_battery: ");
        Integer onBattery = SCANNER.nextInt();
        return new Hub(model, status, serviceLifeEndTime, warrantyEndTime,
                usersMax, roomsMax, devicesMax, sirensMax, onBattery);
    }

    private void createHub() throws SQLException {
        
        Hub hub = getHubInputs();
        hubController.create(hub);
        LOGGER.debug("Hub was added to the table.\nEnter numbers: ");
    }

    private void updateHub() throws SQLException {
        LOGGER.debug("\nEnter id to update:");
        Integer id = SCANNER.nextInt();
        Hub hub = getHubInputs();
        hub.setId(id);
        hubController.update(hub.getId(), hub);
        LOGGER.debug("Updated hub, id = " + id);
    }

    private void deleteHub() throws SQLException {
        LOGGER.debug("\nEnter id to delete hub: ");
        Integer id = SCANNER.nextInt();
        hubController.delete(id);
        LOGGER.debug("Deleted hub, id = " + id);
    }


    private void getAllDevices() throws SQLException {
        
        LOGGER.debug(deviceController.findAll().toString());
    }

    private void getDeviceByName() throws SQLException {
        LOGGER.debug("\nEnter Id: ");
        Integer id = SCANNER.nextInt();
        LOGGER.debug(deviceController.findById(id).toString());
    }

    private Device getDeviceInputs() {
        LOGGER.debug("\nEnter model: ");
        String model = SCANNER.next();
        LOGGER.debug("Enter status: ");
        String status = SCANNER.next();
        SCANNER.nextLine();
        LOGGER.debug("Enter warranty_end_time: ");
        Timestamp warrantyEndTime = Timestamp.valueOf(SCANNER.nextLine());
        LOGGER.debug("Enter service_life_end_time: ");
        Timestamp serviceLifeEndTime = Timestamp.valueOf(SCANNER.nextLine());
        LOGGER.debug("Enter on_battery: ");
        Integer onBattery = SCANNER.nextInt();
        LOGGER.debug("Enter hub_id: ");
        Integer hubId = SCANNER.nextInt();
        return new Device(model, status, serviceLifeEndTime, warrantyEndTime,
                onBattery, hubId);
    }

    private void createDevice() throws SQLException {
        
        Device device = getDeviceInputs();
        deviceController.create(device);
        LOGGER.debug("Device was added to the table.\nEnter numbers: ");
    }

    private void updateDevice() throws SQLException {
        LOGGER.debug("\nEnter id to update : ");
        Integer id = SCANNER.nextInt();
        Device device = getDeviceInputs();
        device.setId(id);
        deviceController.update(device.getId(), device);
        LOGGER.debug("Updated device, id = " + id);
    }

    private void deleteDevice() throws SQLException {
        LOGGER.debug("\nEnter id to delete device: ");
        Integer id = SCANNER.nextInt();
        deviceController.delete(id);
        LOGGER.debug("Deleted device, id = " + id);
    }


    private void getAllNotifications() throws SQLException {
        
        LOGGER.debug(notificationController.findAll().toString());
    }

    private void getNotificationById() throws SQLException {
        LOGGER.debug("\nEnter Id: ");
        Integer id = SCANNER.nextInt();
        LOGGER.debug(notificationController.findById(id).toString());
    }

    private Notification getNotificationInputs() {
        LOGGER.debug("Enter timestamp: ");
        Timestamp timestamp = Timestamp.valueOf(SCANNER.nextLine());
        LOGGER.debug("Enter type: ");
        String type = SCANNER.next();
        LOGGER.debug("\nEnter device_id: ");
        Integer deviceId = SCANNER.nextInt();
        LOGGER.debug("\nEnter hub_id: ");
        Integer hubId = SCANNER.nextInt();
        return new Notification(timestamp, type, deviceId, hubId);
    }

    private void createNotification() throws SQLException {
        
        Notification notification = getNotificationInputs();
        notificationController.create(notification);
        LOGGER.debug("Notification was added to the table.\nEnter numbers: ");
    }

    private void updateNotification() throws SQLException {
        LOGGER.debug("\nEnter id to update:");
        Integer id = SCANNER.nextInt();
        Notification notification = getNotificationInputs();
        notification.setId(id);
        notificationController.update(notification.getId(), notification);
        LOGGER.debug("Updated notification, id = " + id);
    }

    private void deleteNotification() throws SQLException {
        LOGGER.debug("\nEnter id to delete notification: ");
        Integer id = SCANNER.nextInt();
        notificationController.delete(id);
        LOGGER.debug("Deleted notification, id = " + id);
    }


    private void getAllGroups() throws SQLException {
        
        LOGGER.debug(groupController.findAll().toString());
    }

    private void getGroupById() throws SQLException {
        LOGGER.debug("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        LOGGER.debug(groupController.findById(id).toString());
    }

    private Group getGroupInputs() {
        LOGGER.debug("\nEnter name: ");
        String name = SCANNER.next();
        LOGGER.debug("\nEnter description: ");
        String description = SCANNER.next();
        LOGGER.debug("Enter hub_id: ");
        Integer hubId = SCANNER.nextInt();
        return new Group(name, description, hubId);
    }

    private void createGroup() throws SQLException {
        
        Group group = getGroupInputs();
        groupController.create(group);
        LOGGER.debug("Group was added to the table.\nEnter numbers: ");
    }

    private void updateGroup() throws SQLException {
        LOGGER.debug("\nEnter id to update:");
        Integer id = SCANNER.nextInt();
        Group group = getGroupInputs();
        group.setId(id);
        groupController.update(group.getId(), group);
        LOGGER.debug("Updated group, id = " + id);
    }

    private void deleteGroup() throws SQLException {
        LOGGER.debug("\nEnter ID to delete group: ");
        int id = SCANNER.nextInt();
        groupController.delete(id);
        LOGGER.debug("Deleted group, id = " + id);
    }


    private void getAllPermissions() throws SQLException {
        
        LOGGER.debug(permissionController.findAll().toString());
    }

    private void getPermissionById() throws SQLException {
        LOGGER.debug("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        LOGGER.debug(permissionController.findById(id).toString());
    }

    private Permission getPermissionInputs() {
        LOGGER.debug("Enter name: ");
        String name = SCANNER.next();
        LOGGER.debug("Enter description: ");
        String description = SCANNER.next();
        return new Permission(name, description);
    }

    private void createPermission() throws SQLException {
        
        Permission permission = getPermissionInputs();
        permissionController.create(permission);
        LOGGER.debug("Permission was added to the table.\nEnter numbers: ");
    }

    private void updatePermission() throws SQLException {
        LOGGER.debug("\nEnter id to update: ");
        Integer id = SCANNER.nextInt();
        Permission permission = getPermissionInputs();
        permission.setId(id);
        permissionController.update(permission.getId(), permission);
        LOGGER.debug("Updated permission, id = " + id);
    }

    private void deletePermission() throws SQLException {
        LOGGER.debug("\nEnter ID to delete permission: ");
        int id = SCANNER.nextInt();
        permissionController.delete(id);
        LOGGER.debug("Deleted permission, id = " + id);
    }


    private void getAllRexes() throws SQLException {
        
        LOGGER.debug(rexController.findAll().toString());
    }

    private void getRexById() throws SQLException {
        LOGGER.debug("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        LOGGER.debug(rexController.findById(id).toString());
    }

    private Rex getRexInputs() {
        LOGGER.debug("\nEnter name: ");
        String name = SCANNER.next();
        LOGGER.debug("\nEnter range: ");
        String range = SCANNER.next();
        LOGGER.debug("Enter hub_id: ");
        Integer hubId = SCANNER.nextInt();
        return new Rex(name, range, hubId);
    }

    private void createRex() throws SQLException {
        
        Rex rex = getRexInputs();
        rexController.create(rex);
        LOGGER.debug("Rex was added to the table.\nEnter numbers: ");
    }

    private void updateRex() throws SQLException {
        LOGGER.debug("\nEnter id to update: ");
        Integer id = SCANNER.nextInt();
        Rex rex = getRexInputs();
        rex.setId(id);
        rexController.update(rex.getId(), rex);
        LOGGER.debug("Updated rex, id = " + id);
    }

    private void deleteRex() throws SQLException {
        LOGGER.debug("\nEnter id to delete rex: ");
        int id = SCANNER.nextInt();
        rexController.delete(id);
        LOGGER.debug("Deleted rex, id = " + id);
    }
}
