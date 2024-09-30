# Permission schema

Both the access to the assets web interfaces and the access to the data can be restricted.

## Access to assets

By default, a well or a rig can be viewed and managed by all the users that have the role of viewing or managing those assets, respectively. Besides that, it is possible to create tight wells and rigs, which have their access restricted to a group of users.

The access to the assets can be managed on the asset web interface, on the `Access Options` menu.

![Access options are available on wells and on rigs](<../.gitbook/assets/image (181).png>)

If the access must be restricted for a well or a rig, a perspective should be associated to it.

![The perspective selection for an asset](<../.gitbook/assets/image (418).png>)

## Access to data

The access to the data is restricted at the dashboards level.

Each dashboard is associated to a perspective, which is associated to one or more teams.

![The perspective selection for a dashboard](<../.gitbook/assets/image (321).png>)

## Perspectives

Perspectives are tags related to entities that restrict the access to them.

The perspectives are associated to teams on the Team page, in the Live administration web interface.

![Perspectives can be associated to teams](<../.gitbook/assets/image (277).png>)

## User Permissions

Besides the [permissions defined by the Intelie Live platform](https://platform.intelie.com/features/access-permision#user-basic-permissions), other specific permissions are added by the Drilling Solution.



| Permission                                                                                                                |
| ------------------------------------------------------------------------------------------------------------------------- |
| `View wells`                                                                                                              |
| `View rigs`                                                                                                               |
| View rig or wells that are not restricted or that are related to a perspective that the user has access.                  |
| `Manage wells`                                                                                                            |
| `Manage rigs`                                                                                                             |
| Edit rigs or wells that are not restricted or that are related to a perspective that the user has access.                 |
| `View collector`                                                                                                          |
| View Collectors configuration.                                                                                            |
| `Manage collector`view all the configurations on this dropown" e coloca um print do dropdown do lado                      |
| Edit Collectors configuration.                                                                                            |
| `Import data restricted by import goals`                                                                                  |
| Import data to a well, restricted to channels that are represented in an import goal (which is a platform customization). |
| `Advanced import data`                                                                                                    |
| Import data to a well.                                                                                                    |
