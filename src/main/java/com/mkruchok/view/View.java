package com.mkruchok.view;

import com.mkruchok.controller.implementation.*;
import com.mkruchok.model.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.*;


public final class View {
    static final Logger LOGGER = LoggerFactory.getLogger(View.class);
    private static final Scanner SCANNER = new Scanner(System.in, "UTF-8");
    private final Map<String, Printable> menu = new LinkedHashMap<>();
    private final HubController hubController = new HubController();
    private final DeviceController deviceController = new DeviceController();
    private final NotificationController notificationController = new NotificationController();
    private final GroupController groupController = new GroupController();
    private final PermissionController permissionController = new PermissionController();
    private final UserController userController = new UserController();
    private final RexController rexController = new RexController();
    Menu showMenu = new Menu();


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
        showMenu.displayMenu();
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception e) {
                LOGGER.debug(String.valueOf(e));
            }
        } while (SCANNER.hasNext());
    }

    private void getAllUsers() {
        userController.findAll();
        showMenu.displayMenu();
    }

    private void getUserById() {
        LOGGER.debug("\nEnter iD: ");
        Integer id = SCANNER.nextInt();
        LOGGER.debug(userController.findById(id).toString());
        showMenu.displayMenu();
    }

    private User getUserInputs(Integer create) throws NullPointerException {
        LOGGER.debug("Enter email: ");
        String email = SCANNER.next();
        LOGGER.debug("Enter password: ");
        String password = SCANNER.next();
        LOGGER.debug("Enter name: ");
        String name = SCANNER.next();
        Timestamp dateCreated = new Timestamp(System.currentTimeMillis());
        Group groupEntity = null;
        Collection<Hub> userHubs = new ArrayList<>();
        Collection<Permission> userPermissions = new ArrayList<>();
        if (create == 0) {
            LOGGER.debug("Enter group id: ");
            Integer groupId = SCANNER.nextInt();
            LOGGER.debug("Enter hub id that user has: ");
            Integer hubId = SCANNER.nextInt();
            userHubs.add(hubController.findById(hubId));
            LOGGER.debug("Enter permission id that user has: ");
            Integer permissionId = SCANNER.nextInt();
            userPermissions.add(permissionController.findById(permissionId));
            groupEntity = groupController.findById(groupId);
        }
        return new User(null, email, password, dateCreated, name, groupEntity, userHubs, userPermissions);
    }

    private void createUser() {
        User user = getUserInputs(1);
        userController.create(user);
        LOGGER.debug("\nUser was added to the table.\n");
        showMenu.displayMenu();
    }

    private void updateUser() {
        LOGGER.debug("\nEnter id to update: ");
        Integer id = SCANNER.nextInt();
        User user = getUserInputs(0);
        user.setId(id);
        userController.update(user.getId(), user);
        LOGGER.debug("Updated user, id = " + id);
        showMenu.displayMenu();
    }

    private void deleteUser() {
        LOGGER.debug("\nEnter ID to delete user: ");
        int id = SCANNER.nextInt();
        userController.delete(id);
        LOGGER.debug("Deleted user, id = " + id);
        showMenu.displayMenu();
    }


    private void getAllHubs() {
        hubController.findAll();
    }

    private void getHubById() {
        LOGGER.debug("\nEnter Id: ");
        Integer id = SCANNER.nextInt();
        LOGGER.debug(hubController.findById(id).toString());
        showMenu.displayMenu();
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

    private void createHub() {
        Hub hub = getHubInputs();
        hubController.create(hub);
        LOGGER.debug("Hub was added to the table.");
        showMenu.displayMenu();
    }

    private void updateHub() {
        LOGGER.debug("\nEnter id to update:");
        Integer id = SCANNER.nextInt();
        Hub hub = getHubInputs();
        hub.setId(id);
        hubController.update(hub.getId(), hub);
        LOGGER.debug("Updated hub, id = " + id);
        showMenu.displayMenu();
    }

    private void deleteHub() {
        LOGGER.debug("\nEnter id to delete hub: ");
        Integer id = SCANNER.nextInt();
        hubController.delete(id);
        LOGGER.debug("Deleted hub, id = " + id);
        showMenu.displayMenu();
    }


    private void getAllDevices() {
        deviceController.findAll();
        showMenu.displayMenu();
    }

    private void getDeviceByName() {
        LOGGER.debug("\nEnter Id: ");
        Integer id = SCANNER.nextInt();
        LOGGER.debug(deviceController.findById(id).toString());
        showMenu.displayMenu();
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
        Hub hubEntity = hubController.findById(hubId);
        return new Device(model, status, serviceLifeEndTime, warrantyEndTime,
                onBattery, hubEntity);
    }

    private void createDevice() {
        Device device = getDeviceInputs();
        deviceController.create(device);
        LOGGER.debug("Device was added to the table.");
        showMenu.displayMenu();
    }

    private void updateDevice() {
        LOGGER.debug("\nEnter id to update : ");
        Integer id = SCANNER.nextInt();
        Device device = getDeviceInputs();
        device.setId(id);
        deviceController.update(device.getId(), device);
        LOGGER.debug("Updated device, id = " + id);
        showMenu.displayMenu();
    }

    private void deleteDevice() {
        LOGGER.debug("\nEnter id to delete device: ");
        Integer id = SCANNER.nextInt();
        deviceController.delete(id);
        LOGGER.debug("Deleted device, id = " + id);
        showMenu.displayMenu();
    }


    private void getAllNotifications() {
        notificationController.findAll();
        showMenu.displayMenu();
    }

    private void getNotificationById() {
        LOGGER.debug("\nEnter Id: ");
        Integer id = SCANNER.nextInt();
        LOGGER.debug(notificationController.findById(id).toString());
        showMenu.displayMenu();
    }

    private Notification getNotificationInputs() {
        LOGGER.debug("Enter timestamp: ");SCANNER.nextLine();
        Timestamp timestamp = Timestamp.valueOf(SCANNER.nextLine());
        LOGGER.debug("Enter type: ");
        String type = SCANNER.next();
        LOGGER.debug("\nEnter device_id: ");
        Integer deviceId = SCANNER.nextInt();
        Device deviceEntity = deviceController.findById(deviceId);
        LOGGER.debug("\nEnter hub_id: ");
        Integer hubId = SCANNER.nextInt();
        Hub hubEntity = hubController.findById(hubId);
        return new Notification(null, timestamp, type, deviceEntity, hubEntity);
    }

    private void createNotification() {
        Notification notification = getNotificationInputs();
        notificationController.create(notification);
        LOGGER.debug("Notification was added to the table.");
        showMenu.displayMenu();
    }

    private void updateNotification() {
        LOGGER.debug("\nEnter id to update:");
        Integer id = SCANNER.nextInt();
        Notification notification = getNotificationInputs();
        notification.setId(id);
        notificationController.update(notification.getId(), notification);
        LOGGER.debug("Updated notification, id = " + id);
        showMenu.displayMenu();
    }

    private void deleteNotification() {
        LOGGER.debug("\nEnter id to delete notification: ");
        Integer id = SCANNER.nextInt();
        notificationController.delete(id);
        LOGGER.debug("Deleted notification, id = " + id);
        showMenu.displayMenu();
    }


    private void getAllGroups() {
        groupController.findAll();
        showMenu.displayMenu();
    }

    private void getGroupById() {
        LOGGER.debug("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        LOGGER.debug(groupController.findById(id).toString());
        showMenu.displayMenu();
    }

    private Group getGroupInputs() {
        LOGGER.debug("\nEnter name: ");
        String name = SCANNER.next();
        LOGGER.debug("\nEnter description: ");
        String description = SCANNER.next();
        LOGGER.debug("Enter hub_id: ");
        Integer hubId = SCANNER.nextInt();
        Hub hubEntity = hubController.findById(hubId);
        return new Group(name, description, hubEntity);
    }

    private void createGroup() {
        Group group = getGroupInputs();
        groupController.create(group);
        LOGGER.debug("Group was added to the table.");
        showMenu.displayMenu();
    }

    private void updateGroup() {
        LOGGER.debug("\nEnter id to update:");
        Integer id = SCANNER.nextInt();
        Group group = getGroupInputs();
        group.setId(id);
        groupController.update(group.getId(), group);
        LOGGER.debug("Updated group, id = " + id);
        showMenu.displayMenu();
    }

    private void deleteGroup() {
        LOGGER.debug("\nEnter ID to delete group: ");
        int id = SCANNER.nextInt();
        groupController.delete(id);
        LOGGER.debug("Deleted group, id = " + id);
        showMenu.displayMenu();
    }


    private void getAllPermissions() {
        permissionController.findAll();
        showMenu.displayMenu();
    }

    private void getPermissionById() {
        LOGGER.debug("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        LOGGER.debug(permissionController.findById(id).toString());
        showMenu.displayMenu();
    }

    private Permission getPermissionInputs(Integer create) {
        LOGGER.debug("Enter name: ");
        String name = SCANNER.next();
        LOGGER.debug("Enter description: ");
        String description = SCANNER.next();
        Collection<User> permissionUsers = new ArrayList<>();
        Collection<Group> permissionGroups = new ArrayList<>();
        if (create == 0) {
            LOGGER.debug("Enter permission user id: ");
            Integer userId = SCANNER.nextInt();
            permissionUsers.add(userController.findById(userId));
            LOGGER.debug("Enter permission group id: ");
            Integer groupId = SCANNER.nextInt();
            permissionGroups.add(groupController.findById(groupId));
        }
        return new Permission(null, name, description, permissionUsers, permissionGroups);
    }

    private void createPermission() {
        Permission permission = getPermissionInputs(1);
        permissionController.create(permission);
        LOGGER.debug("Permission was added to the table.");
        showMenu.displayMenu();
    }

    private void updatePermission() {
        LOGGER.debug("\nEnter id to update: ");
        Integer id = SCANNER.nextInt();
        Permission permission = getPermissionInputs(0);
        permission.setId(id);
        permissionController.update(permission.getId(), permission);
        LOGGER.debug("Updated permission, id = " + id);
        showMenu.displayMenu();
    }

    private void deletePermission() {
        LOGGER.debug("\nEnter ID to delete permission: ");
        int id = SCANNER.nextInt();
        permissionController.delete(id);
        LOGGER.debug("Deleted permission, id = " + id);
        showMenu.displayMenu();
    }


    private void getAllRexes() {
        rexController.findAll();
        showMenu.displayMenu();
    }

    private void getRexById() {
        LOGGER.debug("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        LOGGER.debug(rexController.findById(id).toString());
        showMenu.displayMenu();
    }

    private Rex getRexInputs() {
        LOGGER.debug("\nEnter name: ");
        String name = SCANNER.next();
        LOGGER.debug("\nEnter range: ");
        String range = SCANNER.next();
        LOGGER.debug("Enter hub_id: ");
        Integer hubId = SCANNER.nextInt();
        Hub hubEntity = hubController.findById(hubId);
        return new Rex(null, name, range, hubEntity);
    }

    private void createRex() {

        Rex rex = getRexInputs();
        rexController.create(rex);
        LOGGER.debug("Rex was added to the table.");
        showMenu.displayMenu();
    }

    private void updateRex() {
        LOGGER.debug("\nEnter id to update: ");
        Integer id = SCANNER.nextInt();
        Rex rex = getRexInputs();
        rex.setId(id);
        rexController.update(rex.getId(), rex);
        LOGGER.debug("Updated rex, id = " + id);
        showMenu.displayMenu();
    }

    private void deleteRex() {
        LOGGER.debug("\nEnter id to delete rex: ");
        int id = SCANNER.nextInt();
        rexController.delete(id);
        LOGGER.debug("Deleted rex, id = " + id);
        showMenu.displayMenu();
    }
}
