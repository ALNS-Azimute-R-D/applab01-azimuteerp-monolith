import { IAssetType } from 'app/entities/asset-type/asset-type.model';
import { IRawAssetProcTmp } from 'app/entities/raw-asset-proc-tmp/raw-asset-proc-tmp.model';
import { IAssetCollection } from 'app/entities/asset-collection/asset-collection.model';
import { StorageTypeEnum } from 'app/entities/enumerations/storage-type-enum.model';
import { StatusAssetEnum } from 'app/entities/enumerations/status-asset-enum.model';
import { PreferredPurposeEnum } from 'app/entities/enumerations/preferred-purpose-enum.model';
import { ActivationStatusEnum } from 'app/entities/enumerations/activation-status-enum.model';

export interface IAsset {
  id: string;
  name?: string | null;
  storageTypeUsed?: keyof typeof StorageTypeEnum | null;
  fullFilenamePath?: string | null;
  status?: keyof typeof StatusAssetEnum | null;
  preferredPurpose?: keyof typeof PreferredPurposeEnum | null;
  assetContentAsBlob?: string | null;
  assetContentAsBlobContentType?: string | null;
  activationStatus?: keyof typeof ActivationStatusEnum | null;
  assetType?: Pick<IAssetType, 'id' | 'name'> | null;
  rawAssetProcTmp?: Pick<IRawAssetProcTmp, 'id' | 'name'> | null;
  assetCollections?: Pick<IAssetCollection, 'id'>[] | null;
}

export type NewAsset = Omit<IAsset, 'id'> & { id: null };
