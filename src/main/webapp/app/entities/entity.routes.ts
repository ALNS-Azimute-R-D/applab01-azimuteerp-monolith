import { Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'country',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.country.home.title' },
    loadChildren: () => import('./country/country.routes'),
  },
  {
    path: 'province',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.province.home.title' },
    loadChildren: () => import('./province/province.routes'),
  },
  {
    path: 'town-city',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.townCity.home.title' },
    loadChildren: () => import('./town-city/town-city.routes'),
  },
  {
    path: 'district',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.district.home.title' },
    loadChildren: () => import('./district/district.routes'),
  },
  {
    path: 'common-locality',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.commonLocality.home.title' },
    loadChildren: () => import('./common-locality/common-locality.routes'),
  },
  {
    path: 'tenant',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.tenant.home.title' },
    loadChildren: () => import('./tenant/tenant.routes'),
  },
  {
    path: 'type-of-organization',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.typeOfOrganization.home.title' },
    loadChildren: () => import('./type-of-organization/type-of-organization.routes'),
  },
  {
    path: 'organization',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.organization.home.title' },
    loadChildren: () => import('./organization/organization.routes'),
  },
  {
    path: 'business-unit',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.businessUnit.home.title' },
    loadChildren: () => import('./business-unit/business-unit.routes'),
  },
  {
    path: 'organization-domain',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.organizationDomain.home.title' },
    loadChildren: () => import('./organization-domain/organization-domain.routes'),
  },
  {
    path: 'organization-attribute',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.organizationAttribute.home.title' },
    loadChildren: () => import('./organization-attribute/organization-attribute.routes'),
  },
  {
    path: 'type-of-person',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.typeOfPerson.home.title' },
    loadChildren: () => import('./type-of-person/type-of-person.routes'),
  },
  {
    path: 'person',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.person.home.title' },
    loadChildren: () => import('./person/person.routes'),
  },
  {
    path: 'organization-role',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.organizationRole.home.title' },
    loadChildren: () => import('./organization-role/organization-role.routes'),
  },
  {
    path: 'organization-membership',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.organizationMembership.home.title' },
    loadChildren: () => import('./organization-membership/organization-membership.routes'),
  },
  {
    path: 'organization-member-role',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.organizationMemberRole.home.title' },
    loadChildren: () => import('./organization-member-role/organization-member-role.routes'),
  },
  {
    path: 'asset-type',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.assetType.home.title' },
    loadChildren: () => import('./asset-type/asset-type.routes'),
  },
  {
    path: 'raw-asset-proc-tmp',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.rawAssetProcTmp.home.title' },
    loadChildren: () => import('./raw-asset-proc-tmp/raw-asset-proc-tmp.routes'),
  },
  {
    path: 'asset',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.asset.home.title' },
    loadChildren: () => import('./asset/asset.routes'),
  },
  {
    path: 'asset-metadata',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.assetMetadata.home.title' },
    loadChildren: () => import('./asset-metadata/asset-metadata.routes'),
  },
  {
    path: 'asset-collection',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.assetCollection.home.title' },
    loadChildren: () => import('./asset-collection/asset-collection.routes'),
  },
  {
    path: 'invoice',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.invoice.home.title' },
    loadChildren: () => import('./invoice/invoice.routes'),
  },
  {
    path: 'payment-gateway',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.paymentGateway.home.title' },
    loadChildren: () => import('./payment-gateway/payment-gateway.routes'),
  },
  {
    path: 'payment',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.payment.home.title' },
    loadChildren: () => import('./payment/payment.routes'),
  },
  {
    path: 'warehouse',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.warehouse.home.title' },
    loadChildren: () => import('./warehouse/warehouse.routes'),
  },
  {
    path: 'supplier',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.supplier.home.title' },
    loadChildren: () => import('./supplier/supplier.routes'),
  },
  {
    path: 'brand',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.brand.home.title' },
    loadChildren: () => import('./brand/brand.routes'),
  },
  {
    path: 'product',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.product.home.title' },
    loadChildren: () => import('./product/product.routes'),
  },
  {
    path: 'inventory-transaction',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.inventoryTransaction.home.title' },
    loadChildren: () => import('./inventory-transaction/inventory-transaction.routes'),
  },
  {
    path: 'stock-level',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.stockLevel.home.title' },
    loadChildren: () => import('./stock-level/stock-level.routes'),
  },
  {
    path: 'customer',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.customer.home.title' },
    loadChildren: () => import('./customer/customer.routes'),
  },
  {
    path: 'customer-type',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.customerType.home.title' },
    loadChildren: () => import('./customer-type/customer-type.routes'),
  },
  {
    path: 'category',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.category.home.title' },
    loadChildren: () => import('./category/category.routes'),
  },
  {
    path: 'article',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.article.home.title' },
    loadChildren: () => import('./article/article.routes'),
  },
  {
    path: 'order',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.order.home.title' },
    loadChildren: () => import('./order/order.routes'),
  },
  {
    path: 'order-item',
    data: { pageTitle: 'azimuteErpSpringAngularMonolith01App.orderItem.home.title' },
    loadChildren: () => import('./order-item/order-item.routes'),
  },
  /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
];

export default routes;
