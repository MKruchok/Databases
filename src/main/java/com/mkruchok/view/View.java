package com.mkruchok.view;

import com.mkruchok.controller.implementation.DeviceController;
import com.mkruchok.controller.implementation.DevicesGroupController;
import com.mkruchok.controller.implementation.HubController;
import com.mkruchok.controller.implementation.NotificationController;
import com.mkruchok.controller.implementation.PermissionController;
import com.mkruchok.controller.implementation.RexController;
import com.mkruchok.controller.implementation.UserController;
import com.mkruchok.controller.implementation.UsersGroupController;
import com.mkruchok.model.entity.Device;
import com.mkruchok.model.entity.DevicesGroup;
import com.mkruchok.model.entity.Hub;
import com.mkruchok.model.entity.Notification;
import com.mkruchok.model.entity.Permission;
import com.mkruchok.model.entity.Rex;
import com.mkruchok.model.entity.User;
import com.mkruchok.model.entity.UsersGroup;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class View {
  static final Logger LOGGER = LoggerFactory.getLogger(View.class);
  private static final Scanner SCANNER = new Scanner(System.in, StandardCharsets.UTF_8);
  private final Map<String, Printable> menu = new LinkedHashMap<>();
  private final HubController hubController = new HubController();
  private final DeviceController deviceController = new DeviceController();
  private final NotificationController notificationController = new NotificationController();
  private final UsersGroupController usersGroupController = new UsersGroupController();
  private final DevicesGroupController devicesGroupController = new DevicesGroupController();
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

    menu.put("51", this::getAllUsersGroups);
    menu.put("52", this::getUsersGroupById);
    menu.put("53", this::createUsersGroup);
    menu.put("54", this::updateUsersGroup);
    menu.put("55", this::deleteUsersGroup);

    menu.put("61", this::getAllDevicesGroups);
    menu.put("62", this::getDevicesGroupById);
    menu.put("63", this::createDevicesGroup);
    menu.put("64", this::updateDevicesGroup);
    menu.put("65", this::deleteDevicesGroup);

    menu.put("71", this::getAllPermissions);
    menu.put("72", this::getPermissionById);
    menu.put("73", this::createPermission);
    menu.put("74", this::updatePermission);
    menu.put("75", this::deletePermission);

    menu.put("81", this::getAllRexes);
    menu.put("82", this::getRexById);
    menu.put("83", this::createRex);
    menu.put("84", this::updateRex);
    menu.put("85", this::deleteRex);
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
    final Integer id = SCANNER.nextInt();
    LOGGER.debug(userController.findById(id).toString());
    showMenu.displayMenu();
  }

  private User getUserInputs() throws NullPointerException {
    LOGGER.debug("Enter email: ");
    final String email = SCANNER.next();
    LOGGER.debug("Enter password: ");
    final String password = SCANNER.next();
    LOGGER.debug("Enter name: ");
    final String name = SCANNER.next();
    final Timestamp dateCreated = new Timestamp(System.currentTimeMillis());
    final UsersGroup groupEntity;
    final Collection<Hub> userHubs = new ArrayList<>();
    final Collection<Permission> userPermissions = new ArrayList<>();
    LOGGER.debug("Enter group id: ");
    final int groupId = SCANNER.nextInt();
    LOGGER.debug("Enter hub id to add or skip (0): ");
    final int hubId = SCANNER.nextInt();
    if (hubId != 0) {
      userHubs.add(hubController.findById(hubId));
    }
    LOGGER.debug("Enter permission id to add or skip(0): ");
    final int permissionId = SCANNER.nextInt();
    if (permissionId != 0) {
      userPermissions.add(permissionController.findById(permissionId));
    }
    groupEntity = groupId == 0 ? null : usersGroupController.findById(groupId);

    return new User(null,
        email,
        password,
        dateCreated,
        name,
        groupEntity,
        userHubs,
        userPermissions);
  }

  private void createUser() {
    final User user = getUserInputs();
    userController.create(user);
    LOGGER.debug("\nUser was added to the table.\n");
    showMenu.displayMenu();
  }

  private void updateUser() {
    LOGGER.debug("\nEnter id to update: ");
    final Integer id = SCANNER.nextInt();
    final User user = getUserInputs();
    user.setId(id);
    userController.update(user.getId(), user);
    LOGGER.debug("Updated user, id = " + id);
    showMenu.displayMenu();
  }

  private void deleteUser() {
    LOGGER.debug("\nEnter ID to delete user: ");
    final int id = SCANNER.nextInt();
    userController.delete(id);
    LOGGER.debug("Deleted user, id = " + id);
    showMenu.displayMenu();
  }


  private void getAllHubs() {
    hubController.findAll();
    showMenu.displayMenu();
  }

  private void getHubById() {
    LOGGER.debug("\nEnter Id: ");
    final Integer id = SCANNER.nextInt();
    LOGGER.debug(hubController.findById(id).toString());
    showMenu.displayMenu();
  }

  private Hub getHubInputs() {
    LOGGER.debug("\nEnter model: ");
    final String model = SCANNER.next();
    LOGGER.debug("Enter status: ");
    final String status = SCANNER.next();
    SCANNER.nextLine();
    LOGGER.debug("Enter service_life_end_time: ");
    final Timestamp serviceLifeEndTime = Timestamp.valueOf(SCANNER.nextLine());
    LOGGER.debug("Enter warranty_end_time: ");
    final Timestamp warrantyEndTime = Timestamp.valueOf(SCANNER.nextLine());
    LOGGER.debug("Enter users_max: ");
    final Integer usersMax = SCANNER.nextInt();
    LOGGER.debug("Enter rooms_max: ");
    final Integer roomsMax = SCANNER.nextInt();
    LOGGER.debug("Enter devices_max: ");
    final Integer devicesMax = SCANNER.nextInt();
    LOGGER.debug("Enter sirens_max: ");
    final Integer sirensMax = SCANNER.nextInt();
    LOGGER.debug("Enter on_battery: ");
    final Integer onBattery = SCANNER.nextInt();
    return new Hub(model,
        status,
        serviceLifeEndTime,
        warrantyEndTime,
        usersMax,
        roomsMax,
        devicesMax,
        sirensMax,
        onBattery);
  }

  private void createHub() {
    final Hub hub = getHubInputs();
    hubController.create(hub);
    LOGGER.debug("Hub was added to the table.");
    showMenu.displayMenu();
  }

  private void updateHub() {
    LOGGER.debug("\nEnter id to update:");
    final Integer id = SCANNER.nextInt();
    final Hub hub = getHubInputs();
    hub.setId(id);
    hubController.update(hub.getId(), hub);
    LOGGER.debug("Updated hub, id = " + id);
    showMenu.displayMenu();
  }

  private void deleteHub() {
    LOGGER.debug("\nEnter id to delete hub: ");
    final Integer id = SCANNER.nextInt();
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
    final Integer id = SCANNER.nextInt();
    LOGGER.debug(deviceController.findById(id).toString());
    showMenu.displayMenu();
  }

  private Device getDeviceInputs() {
    LOGGER.debug("\nEnter model: ");
    final String model = SCANNER.next();
    LOGGER.debug("Enter status: ");
    final String status = SCANNER.next();
    SCANNER.nextLine();
    LOGGER.debug("Enter warranty_end_time: ");
    final Timestamp warrantyEndTime = Timestamp.valueOf(SCANNER.nextLine());
    LOGGER.debug("Enter service_life_end_time: ");
    final Timestamp serviceLifeEndTime = Timestamp.valueOf(SCANNER.nextLine());
    LOGGER.debug("Enter on_battery: ");
    final Integer onBattery = SCANNER.nextInt();
    LOGGER.debug("Enter hub_id: ");
    int hubIdNull = SCANNER.nextInt();
    Hub hubEntity = hubIdNull == 0 ? null : hubController.findById(hubIdNull);
    LOGGER.debug("Enter devices_group_id: ");
    int groupIdNull = SCANNER.nextInt();
    DevicesGroup deviceEntity =
        groupIdNull == 0 ? null : devicesGroupController.findById(groupIdNull);
    return new Device(model,
        status,
        serviceLifeEndTime,
        warrantyEndTime,
        onBattery,
        hubEntity,
        deviceEntity);
  }

  private void createDevice() {
    final Device device = getDeviceInputs();
    deviceController.create(device);
    LOGGER.debug("Device was added to the table.");
    showMenu.displayMenu();
  }

  private void updateDevice() {
    LOGGER.debug("\nEnter id to update : ");
    final Integer id = SCANNER.nextInt();
    final Device device = getDeviceInputs();
    device.setId(id);
    deviceController.update(device.getId(), device);
    LOGGER.debug("Updated device, id = " + id);
    showMenu.displayMenu();
  }

  private void deleteDevice() {
    LOGGER.debug("\nEnter id to delete device: ");
    final Integer id = SCANNER.nextInt();
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
    final Integer id = SCANNER.nextInt();
    LOGGER.debug(notificationController.findById(id).toString());
    showMenu.displayMenu();
  }

  private Notification getNotificationInputs() {
    LOGGER.debug("Enter timestamp: ");
    SCANNER.nextLine();
    final Timestamp timestamp = Timestamp.valueOf(SCANNER.nextLine());
    LOGGER.debug("Enter type: ");
    final String type = SCANNER.next();
    LOGGER.debug("\nEnter device_id: ");
    Integer deviceIdNull = SCANNER.nextInt();
    deviceIdNull = deviceIdNull == 0 ? null : deviceIdNull;
    final Device deviceEntity = deviceController.findById(deviceIdNull);
    LOGGER.debug("\nEnter hub_id: ");
    Integer hubIdNull = SCANNER.nextInt();
    hubIdNull = hubIdNull == 0 ? null : hubIdNull;
    final Hub hubEntity = hubController.findById(hubIdNull);
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


  private void getAllUsersGroups() {
    usersGroupController.findAll();
    showMenu.displayMenu();
  }

  private void getUsersGroupById() {
    LOGGER.debug("\nEnter ID: ");
    Integer id = SCANNER.nextInt();
    LOGGER.debug(usersGroupController.findById(id).toString());
    showMenu.displayMenu();
  }

  private UsersGroup getUsersGroupInputs() {
    LOGGER.debug("\nEnter name: ");
    String name = SCANNER.next();
    LOGGER.debug("\nEnter description: ");
    String description = SCANNER.next();
    LOGGER.debug("Enter hub_id: ");
    Integer hubId = SCANNER.nextInt();
    Hub hubEntity = hubController.findById(hubId);
    return new UsersGroup(name, description, hubEntity);
  }

  private void createUsersGroup() {
    UsersGroup group = getUsersGroupInputs();
    usersGroupController.create(group);
    LOGGER.debug("Group was added to the table.");
    showMenu.displayMenu();
  }

  private void updateUsersGroup() {
    LOGGER.debug("\nEnter id to update:");
    Integer id = SCANNER.nextInt();
    UsersGroup group = getUsersGroupInputs();
    group.setId(id);
    usersGroupController.update(group.getId(), group);
    LOGGER.debug("Updated group, id = " + id);
    showMenu.displayMenu();
  }

  private void deleteUsersGroup() {
    LOGGER.debug("\nEnter ID to delete group: ");
    int id = SCANNER.nextInt();
    usersGroupController.delete(id);
    LOGGER.debug("Deleted group, id = " + id);
    showMenu.displayMenu();
  }


  private void getAllDevicesGroups() {
    devicesGroupController.findAll();
    showMenu.displayMenu();
  }

  private void getDevicesGroupById() {
    LOGGER.debug("\nEnter ID: ");
    Integer id = SCANNER.nextInt();
    LOGGER.debug(devicesGroupController.findById(id).toString());
    showMenu.displayMenu();
  }

  private DevicesGroup getDevicesGroupInputs() {
    LOGGER.debug("\nEnter name: ");
    String name = SCANNER.next();
    return new DevicesGroup(null, name, null);
  }

  private void createDevicesGroup() {
    DevicesGroup group = getDevicesGroupInputs();
    devicesGroupController.create(group);
    LOGGER.debug("Group was added to the table.");
    showMenu.displayMenu();
  }

  private void updateDevicesGroup() {
    LOGGER.debug("\nEnter id to update:");
    Integer id = SCANNER.nextInt();
    DevicesGroup group = getDevicesGroupInputs();
    group.setId(id);
    devicesGroupController.update(group.getId(), group);
    LOGGER.debug("Updated group, id = " + id);
    showMenu.displayMenu();
  }

  private void deleteDevicesGroup() {
    LOGGER.debug("\nEnter ID to delete group: ");
    int id = SCANNER.nextInt();
    usersGroupController.delete(id);
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

  private Permission getPermissionInputs() {
    LOGGER.debug("Enter permission_name: ");
    final String name = SCANNER.next();
    LOGGER.debug("Enter hub_id: ");
    int hubIdNull = SCANNER.nextInt();
    final Hub hubId = hubIdNull == 0 ? null : hubController.findById(hubIdNull);
    LOGGER.debug("Enter user_id: ");
    int userIdNull = SCANNER.nextInt();
    final User userId = userIdNull == 0 ? null : userController.findById(userIdNull);
    LOGGER.debug("Enter group_id: ");
    int groupIdNull = SCANNER.nextInt();
    final UsersGroup groupId = groupIdNull == 0 ? null : usersGroupController.findById(groupIdNull);
    LOGGER.debug("Enter device_id: ");
    int deviceIdNull = SCANNER.nextInt();
    Device deviceId = deviceIdNull == 0 ? null : deviceController.findById(deviceIdNull);
    return new Permission(null, name, hubId, userId, groupId, deviceId);
  }

  private void createPermission() {
    Permission permission = getPermissionInputs();
    permissionController.create(permission);
    LOGGER.debug("Permission was added to the table.");
    showMenu.displayMenu();
  }

  private void updatePermission() {
    LOGGER.debug("\nEnter id to update: ");
    Integer id = SCANNER.nextInt();
    Permission permission = getPermissionInputs();
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
