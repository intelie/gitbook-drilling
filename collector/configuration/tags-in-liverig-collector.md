# Tags in LiveRig Collector

In the configuration of the sources, in the **LiveRig Collector** application, there is an option to add tags in the **Event Type** field.\
\
<img src="../../.gitbook/assets/Captura de tela de 2020-06-24 18-05-08.png" alt="" data-size="original">\
\
In this way, the user can dynamically filter through information using the **Event Type** field so that the same data source can be automatically partitioned into different collections.\
\
**Minimum version**

{% hint style="info" %}
* **Live version 2.27**
* **Live should contain the Liverig plugin version 2.25**
{% endhint %}

## How to use tags

Guide that demonstrates how to use the tags.

## LiveRig Collector

Adding tags in the **event type** field of an existing source.

![Add tags to the event type field](<../../.gitbook/assets/Captura de tela de 2020-06-24 18-08-06.png>)

Available tags

{% hint style="info" %}
**{well-uid} -** UID of well\
**{well-name} -** Name of well\
**{wellbore-uid} -** UID of wellbore\
**{wellbore-name} -** Name of wellbore\
**{object-uid} -** UID of object\
**{object-name} -** Name of object\
**{object-type} -** Type of object\
**{index-type} -** Type of index
{% endhint %}

In this example we will add the following tags: **{well-uid}**, **{object-type}** and **{object-uid}**, in the image below, the result of the **event type** field.

![New event type field value](<../../.gitbook/assets/Captura de tela de 2020-06-24 18-27-10.png>)

{% hint style="danger" %}
**It’s important to note that only the tags described in this guide exist. It’s not possible to create new tags, so, creating a name within {} will be just another textual information and not a tag.**
{% endhint %}

## Live

After saving the new source settings in the **LiveRig Collector** application, we can see the changes in **Live** application.\
\
When selecting the modified source in the **collectors** window, the following result will be displayed.\


![You can see the tags in the event type fields](<../../.gitbook/assets/Captura de tela de 2020-06-25 18-02-56.png>)

## Live Console

In this step, we will use the **Live console** to filter some events using the tags.

![Filtering all raw\_NS01 data](<../../.gitbook/assets/Captura de tela de 2020-06-25 18-34-39.png>)

We can see in the image above that the **\_\_types** bring in their value the translation of the tags, example:\
\
**`NS01{well-uid}{object-type}{object-uid}`**

1. raw\_ns01 **well\_uid\_1 log log\_uid\_1**
2. raw\_ns01 **well\_uid\_1 log log\_uid\_2**

We can add a specific filter for each event, for example:

![Using  raw\_ns01well\_uid\_1loglog\_uid\_1 to filter](<../../.gitbook/assets/Captura de tela de 2020-06-26 17-26-53.png>)

In the **LIVERIG\_METADATA** field, when we add tags to the event type of a collector, a new field is added, **parsed\_event\_type**, which has the name translated from the tags with the event values, whereas the **rig\_name** field has the original name, that is, with the tags added.

![](<../../.gitbook/assets/Captura de tela de 2020-06-25 18-50-45.png>)

## Asset Configuration

Using an event type with tags, we can create filters for an **asset**, generalizing or specifying a pipe filter, example:\
\
\*\*\*\*In the image below, was created a **RIG**, the **RT13**, with a specific filter: **raw\_ns01well\_uid\_1loglog\_uid\_1**

![](<../../.gitbook/assets/Captura de tela de 2020-06-26 17-38-22.png>)

We can see the data coming through the **channels not configured** with the information from the **tags**:

![](<../../.gitbook/assets/Captura de tela de 2020-06-26 18-08-15.png>)

![](<../../.gitbook/assets/Captura de tela de 2020-06-26 18-08-28.png>)

## Conclusion

This guide demonstrates the new functionality of adding tags to the **Rig Collector event type** field. We see that this way we can create filters more dynamically, below some examples of use.

> **NS01{well-uid}{object-type}{object-uid} -> Distinct information**\
> \*\*\*\*\
> **NS01{well-uid}{well-uid}{object-uid} -> Repeated information**\
> \*\*\*\*\
> **NS01{well-uid}trajectory{object-uid} -> Fixed information**\
> \*\*\*\*\
> **NS01\_{well-uid}\_{object-type}\_{object-uid} -> Distinct information separating by underline**
